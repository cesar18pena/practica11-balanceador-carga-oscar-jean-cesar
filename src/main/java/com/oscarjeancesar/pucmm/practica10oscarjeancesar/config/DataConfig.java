package com.oscarjeancesar.pucmm.practica10oscarjeancesar.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//@Configuration
//@PropertySource("application.properties")
public class DataConfig {
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        Resource config = new ClassPathResource("hibernate.cfg.xml");
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setConfigLocation(config);
//        sessionFactory.setPackagesToScan(env.getProperty("practica10oscarjeancesar.entity.package"));
//        sessionFactory.setDataSource(dataSource());
//        return sessionFactory;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource ds = new BasicDataSource();
//
//        ds.setDriverClassName(env.getProperty("practica10oscarjeancesar.db.driver"));
//        ds.setUrl(env.getProperty("practica10oscarjeancesar.db.url"));
//        ds.setUsername(env.getProperty("practica10oscarjeancesar.db.username"));
//        ds.setPassword(env.getProperty("practica10oscarjeancesar.db.password"));
//
//        return ds;
//    }

//    @ConditionalOnBean(name = "dataSource")
//    @ConditionalOnMissingBean
//    @Bean(name="entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
////        em.setPackagesToScan("com.oscarjeancesar.pucmm.practica10oscarjeancesar.config");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        return em;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(type = "JpaTransactionManager")
//    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
}
