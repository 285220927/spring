/*
 * @Project: springTest_maven
 * @Package spring.utils
 * @author: zzc
 * @date Date: 2019年06月27日 上午5:33
 * @version V1.0
 */

package spring.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import spring.config.SpringConfiguration;
import spring.domain.Account;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("threadLocalUtils")
public class ThreadLocalUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    @Resource(name = "dataSource")
    private DataSource dataSource;

    public void setThreadLocal(ThreadLocal<Connection> threadLocal) {
        this.threadLocal = threadLocal;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            Connection conn = threadLocal.get();
            if (conn == null) {
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void release() {
        threadLocal.remove();
    }
}
