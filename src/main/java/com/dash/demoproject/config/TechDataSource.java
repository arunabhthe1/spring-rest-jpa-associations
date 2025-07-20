package com.dash.demoproject.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef="songEntityManagerFactory",transactionManagerRef="songTransactionManager",basePackages = {"com.dash.demoproject.model"})
public class TechDataSource {

	
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource Datasource() {
    	DataSource ds= DataSourceBuilder.create().build();
    	return ds;
    }
    
    
 
}
