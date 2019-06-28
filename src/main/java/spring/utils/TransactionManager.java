/*
 * @Project: springTest_maven
 * @Package spring.utils
 * @author: zzc
 * @date Date: 2019年06月27日 上午5:33
 * @version V1.0
 */

package spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import spring.config.SpringConfiguration;
import spring.service.AccountServiceImpl;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("transactionManager")
@Aspect
public class TransactionManager {
    @Resource(name = "threadLocalUtils")
    private ThreadLocalUtils threadLocal;

    public void beginTransaction() {
        try {
            threadLocal.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            threadLocal.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            threadLocal.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            threadLocal.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Pointcut("execution(* spring.service.AccountServiceImpl.transactionAmount(..))")
    public void pt1() {
    }

    @Around("pt1()")
    public Object transaction(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();
            this.beginTransaction();
            rtValue = pjp.proceed(args);
            this.commit();
            return rtValue;
        } catch (Throwable t) {
            this.rollback();
            throw new RuntimeException(t);
        } finally {
            this.close();
        }
    }
}
