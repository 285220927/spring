/*
 * @Project: springTest_maven
 * @Package spring.service
 * @author: zzc
 * @date Date: 2019年06月24日 上午7:47
 * @version V1.0
 */

package spring.service;

import org.apache.commons.dbutils.QueryRunner;
import spring.dao.AccountDao;
import spring.domain.Account;
import org.springframework.stereotype.Service;
import spring.utils.TransactionManager;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;
    @Resource(name = "transactionManager")
    private TransactionManager transactionManager;
    @Resource(name = "runner")
    private QueryRunner runner;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void transactionAmount(int sourceId, int targetId, double money){
        Account sourceAccount = findById(sourceId);
        Account targetAccount = findById(targetId);

        if (sourceAccount.getMoney() < money || money <= 0) {
            throw new RuntimeException("金额不足或金额数量错误");
        }
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        this.updateAccount(sourceAccount);
        // int a = 3/0;
        this.updateAccount(targetAccount);
    }
}
