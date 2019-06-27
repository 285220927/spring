/*
 * @Project: springTest_maven
 * @Package spring.utils
 * @author: zzc
 * @date Date: 2019年06月27日 上午5:33
 * @version V1.0
 */

package spring.utils;

import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import spring.config.SpringConfiguration;
import spring.service.AccountServiceImpl;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("transactionManager")
public class TransactionManager {
    @Resource(name = "threadLocalUtils")
    private ThreadLocalUtils threadLocal;

    public void beginTrasaction() {
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
        } finally {
            threadLocal.release();
        }
    }
}
