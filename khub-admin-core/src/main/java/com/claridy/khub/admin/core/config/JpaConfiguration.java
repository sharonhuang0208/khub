package com.claridy.khub.admin.core.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import static org.hibernate.cfg.Environment.*;
import static org.hibernate.jpa.AvailableSettings.*;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackages = { "com.claridy.khub.admin.core.repository" })
@ComponentScan({ "com.claridy.khub.admin.core.domain", "com.claridy.khub.admin.core.repository",
        "com.claridy.khub.admin.core.persistent"})
public class JpaConfiguration {

    @Value("${hibernate.dialect:org.hibernate.dialect.MySQLDialect}")
    private String hibernateDialect;

    @Value("${hibernate.hbm2ddl.auto:validate}")
    private String hibernateHbm2ddlAuto;

    @Value("${hibernate.hbm2ddl.import_files:NonExist_File_Prevent_TO_IMPORT}")
    private String hibernateHbm2ddlImportFiles;

    @Value("${hibernate.default_schema:khub}")
    private String hibernateDefaultSchema;

    @Value("${javax.persistence.create-database-schemas:false}")
    private Boolean createDatabaseSchemas;


    @Bean
    public Map<String, String> jpaProperties(DataSource dataSource) throws SQLException{
        Map<String, String> jpaProperties = new HashMap<String, String>();

        jpaProperties.put(DIALECT, hibernateDialect);
        jpaProperties.put(PHYSICAL_NAMING_STRATEGY, "com.claridy.khub.admin.core.hibernate.ImprovedNamingStrategy");
        jpaProperties.put(DEFAULT_SCHEMA, hibernateDefaultSchema);

        jpaProperties.put(SCHEMA_GEN_DB_NAME, dataSource.getConnection().getMetaData().getDatabaseProductName());
        jpaProperties.put(SCHEMA_GEN_DB_MAJOR_VERSION, dataSource.getConnection().getMetaData().getDatabaseProductVersion());
        jpaProperties.put(HBM2DDL_AUTO, hibernateHbm2ddlAuto);
        jpaProperties.put(HBM2DDL_IMPORT_FILES, hibernateHbm2ddlImportFiles);

        if (createDatabaseSchemas) {
            jpaProperties.put(SCHEMA_GEN_CREATE_SCHEMAS, createDatabaseSchemas.toString());
            jpaProperties.put(SCHEMA_GEN_SCRIPTS_ACTION, "drop-and-create");
            jpaProperties.put(SCHEMA_GEN_SCRIPTS_CREATE_TARGET, "src/main/resources/sql/schema.sql");
            jpaProperties.put(SCHEMA_GEN_SCRIPTS_DROP_TARGET, "src/main/resources/sql/drop.sql");
        }

        return jpaProperties;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
//        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws SQLException{
        return new JpaTransactionManager(entityManagerFactory(dataSource).getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) throws SQLException{
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(this.jpaProperties(dataSource));
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(this.jpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.claridy.khub.admin.core.domain");
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public DataSource dataSource(@Value("${jdbc.driverClassName}") String driverClassName,
            @Value("${jdbc.url}") String url, @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
