/*
 * @Project: springTest_maven
 * @Package spring.service.dao
 * @author: zzc
 * @date Date: 2019年06月24日 上午7:44
 * @version V1.0
 */

package spring.dao;

import spring.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    Account findById(int id);

    void updateAccount(Account account);
}
