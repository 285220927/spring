/*
 * @Project: springTest_maven
 * @Package spring.config
 * @author: zzc
 * @date Date: 2019年06月25日 上午7:40
 * @version V1.0
 */

package spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@ComponentScan(basePackages = "spring")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
    @Value("${DriverClass}")
    private String DriverClass;

    @Value("${JdbcUrl}")
    private String JdbcUrl;

    @Value("${Un}")
    private String Un;

    @Value("${Password}")
    private String Password;

    @Bean(name = "runner")
    public QueryRunner runner(@Qualifier("ds") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name = "ds")
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(DriverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(JdbcUrl);
        dataSource.setUser(Un);
        dataSource.setPassword(Password);
        return dataSource;
    }
}
