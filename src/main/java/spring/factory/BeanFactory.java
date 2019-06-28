/*
 * @Project: springTest_maven
 * @Package spring.factory
 * @author: zzc
 * @date Date: 2019年06月27日 上午8:03
 * @version V1.0
 */

package spring.factory;

import org.springframework.stereotype.Component;
import spring.service.AccountService;
import spring.service.AccountServiceImpl;
import spring.utils.TransactionManager;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//@Component("beanFactory")
//public class BeanFactory {
//    @Resource(name = "accountService")
//    private AccountServiceImpl accountService;
//    @Resource(name = "transactionManager")
//    private TransactionManager transactionManager;
//
//    public AccountService getProxyAccountService() {
//        AccountService ProxyaccountService = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object returnValue = null;
//                try {
//                    transactionManager.beginTrasaction();
//                    returnValue = method.invoke(accountService, args);
//                    transactionManager.commit();
//                } catch (Exception e) {
//                    transactionManager.rollback();
//                    e.printStackTrace();
//                } finally {
//                    transactionManager.close();
//                }
//                return returnValue;
//            }
//        });
//        return ProxyaccountService;
//    }
//}
