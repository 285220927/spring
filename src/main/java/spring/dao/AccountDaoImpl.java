/*
 * @Project: springTest_maven
 * @Package spring.service.dao
 * @author: zzc
 * @date Date: 2019年06月24日 上午7:48
 * @version V1.0
 */

package spring.dao;

import spring.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource(name = "runner")
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account findById(int id) {
        try {
            return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertAccount(Account account) {
        try {
            runner.update("insert into account(money, user_id) values(?, ?)", account.getMoney(), account.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int id) {
        try {
            runner.update("delete from account where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set money = ? where id = ?", account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
