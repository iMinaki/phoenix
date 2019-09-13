package com.lee.phoenix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration
@EnableJpaRepositories("com.lee.phoenix.repo")
public class DatabaseConfig {

//    @Autowired
//    ConnectionSetting connectionSetting;
//
//    @Bean(name = "jdbcTemplate")
//    public JdbcTemplate JdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }
//
//    @Bean(name = "namedParameterJdbcTemplate")
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
//        return new NamedParameterJdbcTemplate(dataSource());
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        if (ExtraConfig.isDev()) {
//            dataSource.setMaxTotal(20);
//            dataSource.setInitialSize(8);
//            dataSource.setMinIdle(8);
//            dataSource.setMaxIdle(12);
//        } else {
//            dataSource.setMaxTotal(150);
//            dataSource.setInitialSize(40);
//            dataSource.setMinIdle(40);
//            dataSource.setMaxIdle(80);
//        }
//        dataSource.setMaxWaitMillis(10000);
//        dataSource.setRemoveAbandonedTimeout(10);
//
//        dataSource.setDriverClassName(connectionSetting.getDriver());
//        dataSource.setUrl(connectionSetting.getUrl() + "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE");
//        dataSource.setUsername(connectionSetting.getUsername());
//        dataSource.setPassword(connectionSetting.getPassword());
//        ArrayList<String> initSQLs = new ArrayList<String>();
//        initSQLs.add("SET NAMES 'utf8mb4'");
//        dataSource.setConnectionInitSqls(initSQLs);
//        dataSource.setCacheState(false);
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
//        lef.setDataSource(dataSource());
//        lef.setJpaVendorAdapter(jpaVendorAdapter());
//        lef.setPackagesToScan("com.forzadata.pttool.core.db.domain");
//        return lef;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        vendorAdapter.setDatabase(Database.MYSQL);
//        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//        //vendorAdapter.setShowSql(true);
//
//        return vendorAdapter;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new JpaTransactionManager();
//    }
}