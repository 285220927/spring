/*
 * @Project: springTest_maven
 * @Package aop
 * @author: zzc
 * @date Date: 2019年06月27日 上午8:36
 * @version V1.0
 */

package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("accountTest")
public class AccountTest {

    public void before() {
        System.out.println("前置方法调用...");
    }

    public void afterReturning() {
        System.out.println("后置方法调用...");
    }

    public void afterThrowing() {
        System.out.println("异常方法调用...");
    }

    public void after() {
        System.out.println("最终方法调用...");
    }
}
