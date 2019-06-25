/*
 * @Project: springTest_maven
 * @Package spring.service
 * @author: zzc
 * @date Date: 2019年06月24日 上午7:47
 * @version V1.0
 */

package spring.service;

import spring.dao.AccountDao;
import spring.domain.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }

    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
}
