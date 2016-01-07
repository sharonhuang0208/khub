package com.claridy.khub.admin.core.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = { "com.claridy.khub.admin.core.repository" })
@ComponentScan(basePackages = { "com.claridy.khub.admin.core.domai", "com.claridy.khub.admin.core.repository" })
public class JpaConfiguration {

    @Value("#{dataSource}")
    private javax.sql.DataSource dataSource;
    @Value("${hibernate.dialect:org.hibernate.dialect.MySQLDialect}")
    private String hibernateDialect;

    @Bean
    public Map<String, String> jpaProperties() {
        Map<String, String> jpaProperties = new HashMap<String, String>();
        jpaProperties.put("hibernate.dialect", hibernateDialect);

        /*
         *  hibernate naming strategy for hibernate 4.x and below
        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        */
        jpaProperties.put("hibernate.physical_naming_strategy", "com.claridy.khub.admin.core.hibernate.ImprovedNamingStrategy");

        jpaProperties.put(Environment.HBM2DDL_AUTO, "create");
        jpaProperties.put("javax.persistence.schema-generation.create-database-schemas", "true");
        jpaProperties.put("javax.persistence.schema-generation.scripts.action", "create");
        jpaProperties.put("javax.persistence.schema-generation.scripts.create-target", "src/test/resources/schema.sql");

        /*
        jpaProperties.put(Environment.HBM2DDL_IMPORT_FILES, "data.sql");
        jpaProperties.put("javax.persistence.database-product-name", "HSQL");
        jpaProperties.put("jadira.usertype.autoRegisterUserTypes", "true");
        jpaProperties.put("jadira.usertype.databaseZone", "jvm");
        jpaProperties.put("jadira.usertype.javaZone", "jvm");
        */
        // props.put("hibernate.cache.provider_class",
        // HashtableCacheProvider.class.getName());
        return jpaProperties;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lcef = new LocalContainerEntityManagerFactoryBean();
        lcef.setDataSource(this.dataSource);
        lcef.setJpaPropertyMap(this.jpaProperties());
        lcef.setJpaVendorAdapter(this.jpaVendorAdapter());
        lcef.setPackagesToScan("com.claridy.khub.admin.core.domain");
        return lcef;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("persistent.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

}
