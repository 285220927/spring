/*
 * @Project: springTest_maven
 * @Package spring.utils
 * @author: zzc
 * @date Date: 2019年06月27日 上午5:33
 * @version V1.0
 */

package spring.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("threadLocalUtils")
public class ThreadLocalUtils {
    @Resource(name = "threadLocal")
    private ThreadLocal<Connection> threadLocal;
    @Resource(name = "dataSource")
    private DataSource dataSource;
    private Connection conn;

    public Connection getConnection() {
        try {
            conn = threadLocal.get();
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
