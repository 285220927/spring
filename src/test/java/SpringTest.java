/*
 * @Project: springTest_maven
 * @Package PACKAGE_NAME
 * @author: zzc
 * @date Date: 2019年06月24日 上午8:14
 * @version V1.0
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.config.SpringConfiguration;
import spring.domain.Account;
import org.junit.Test;
import spring.factory.BeanFactory;
import spring.service.AccountService;
import spring.service.AccountServiceImpl;
import spring.utils.ThreadLocalUtils;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
// location用来指明xml配置，用classpath:bean.xml
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringTest {
    // 自己写的类 用注解配置方便，源码提供的类，由于不能在源码上添加注解，所以使用xml方便（也可以定义一个类来配置）

    // 使用xml配置
    // private ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
    // private AccountDao accountService = classPathXmlApplicationContext.getBean("accountService", AccountDao.class);

    // 使用类配置
    // private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    // private AccountDao accountService = ac.getBean("accountService", AccountDao.class);

    // junit环境下
    @Resource(name = "accountService")
    private AccountService accountService;
    @Resource(name = "threadLocalUtils")
    private ThreadLocalUtils threadLocalUtils;
    @Resource(name = "beanFactory")
    private BeanFactory beanFactory;

    @Test
    public void findAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void findOne() {
        Account account = accountService.findById(3);
        System.out.println(account);
    }

    @Test
    public void transactionAmount() {
        // accountService.transactionAmount(5, 6, 100);
        // 创建代理对象
        AccountService accountService = beanFactory.getProxyAccountService();
        accountService.transactionAmount(5, 6, 100);
    }
}
