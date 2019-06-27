/*
 * @Project: springTest_maven
 * @Package spring.service
 * @author: zzc
 * @date Date: 2019年06月24日 上午7:46
 * @version V1.0
 */

package spring.service;

import spring.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(int id);

    void updateAccount(Account account);

    void transactionAmount(int sourceId, int targetId, double money);
}
