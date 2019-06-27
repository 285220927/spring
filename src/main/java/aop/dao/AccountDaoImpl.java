/*
 * @Project: springTest_maven
 * @Package aop.dao
 * @author: zzc
 * @date Date: 2019年06月27日 上午9:16
 * @version V1.0
 */

package aop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component("accountAopDao")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("保存用户信息");
    }
}
