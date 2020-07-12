package com.example.demo1.vo;

import com.mysql.cj.conf.DatabaseUrlContainer;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 配置文件
 */
@Component
@ConfigurationProperties("database")
@Conditional(DatabaseConditional.class)
public class DataBaseProperties {

    @Value("${database.driverName}")
    private String driverName;

    @Value("${database.url}")
    private String url;

    private String username;

    private String password;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        System.out.println("driverName = " + driverName);
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        System.out.println("url = " + url);
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    //@Value("${database.username}")
    public void setUsername(String username) {
        System.out.println("username = " + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    //@Value("${database.password}")
    public void setPassword(String password) {
        System.out.println("password = " + password);
        this.password = password;
    }

    @Bean(name = "dataSource")
    @Conditional(DatabaseConditional.class)
    public DataSource getDataSource(
            @Value("${database.driverName}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String pwd
    ){
        Properties prop = new Properties();
        prop.setProperty("driver",driver);
        prop.setProperty("url",url);
        prop.setProperty("username",username);
        prop.setProperty("password",pwd);
        DataSource dataSource = null;
        try{
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e){
            e.printStackTrace();
        }
        return dataSource;
    }
}
