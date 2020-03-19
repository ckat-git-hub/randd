package com.data.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.data.repository")
@PropertySource(value = "classpath:database.properties")
public class AntiqueDataConfiguration {

    @Value("${antiquedata.mysql.driver}")
	private String PROPERTY_DRIVER;
    
    @Value("${antiquedata.mysql.url}")
    private String PROPERTY_URL;
    
    @Value("${antiquedata.mysql.username}")
    private String PROPERTY_USERNAME;
    
    @Value("${antiquedata.mysql.password}")
    private String PROPERTY_PASSWORD;
    
    @Value("${hibernate.show_sql}")
    private String PROPERTY_SHOW_SQL;
    
    @Value("${hibernate.dialect}")
    private String PROPERTY_DIALECT;
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(getDataSource());
		lcemfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lcemfb.setPackagesToScan("com.data.entity");
		lcemfb.setJpaProperties(getHibernateProperties());
		return lcemfb;
	}

	@Bean
	DataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		try {
			ds.setUrl(PROPERTY_URL);
			ds.setDriverClassName(PROPERTY_DRIVER);
			ds.setUsername(PROPERTY_USERNAME);
			ds.setPassword(PROPERTY_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Bean
	Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", PROPERTY_DIALECT);
		properties.setProperty("hibernate.show_sql", PROPERTY_SHOW_SQL);
		return properties;
	}

	@Bean
	JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	} 
}
