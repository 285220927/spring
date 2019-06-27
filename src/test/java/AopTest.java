/*
 * @Project: springTest_maven
 * @Package PACKAGE_NAME
 * @author: zzc
 * @date Date: 2019年06月27日 上午8:45
 * @version V1.0
 */

import aop.AccountTest;
import aop.dao.AccountDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import aop.dao.AccountDao;

import javax.annotation.Resource;

public class AopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("aopBean.xml");
        AccountDaoImpl accountDao = ac.getBean("accountDao", AccountDaoImpl.class);
        accountDao.saveAccount();
    }
}
