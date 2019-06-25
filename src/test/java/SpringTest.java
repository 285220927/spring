/*
 * @Project: springTest_maven
 * @Package PACKAGE_NAME
 * @author: zzc
 * @date Date: 2019年06月24日 上午8:14
 * @version V1.0
 */

import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.config.SpringConfiguration;
import spring.dao.AccountDao;
import spring.domain.Account;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
// location用来指明xml配置，用classpath:bean.xml
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringTest {
    // 自己写的类 用注解配置方便，源码提供的类，由于不能在源码上添加注解，所以使用xml方便（也可以定义一个类来配置）

    // 使用xml配置
    // private ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
    // private AccountDao accountDao = classPathXmlApplicationContext.getBean("accountDao", AccountDao.class);

    // 使用类配置
    // private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    // private AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

    // junit环境下
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Test
    public void findAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void findOne() {
        Account account = accountDao.findById(3);
        System.out.println(account);
    }

    @Test
    public void insert() {
        Account account = new Account();
        account.setMoney(450);
        account.setUser_id(2);
        accountDao.insertAccount(account);
    }

    @Test
    public void delete() {
        accountDao.deleteAccount(6);
    }

    @Test
    public void update() {
        Account account = new Account();
        account.setId(6);
        account.setMoney(650);
        accountDao.updateAccount(account);
    }
}
