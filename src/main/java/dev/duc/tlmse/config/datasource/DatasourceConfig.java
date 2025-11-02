package dev.duc.tlmse.config.datasource;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.mapping.Property;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * JPA DataSource Configuration.
 *
 * <p>This configuration defines how the application connects to the database
 * and manages entities using JPA and a persistence provider (e.g. Hibernate).</p>
 *
 * <ul>
 *   <li><b>DataSource Configuration:</b> Defines connection properties such as
 *       URL, username, password, and driver class.</li>
 *   <li><b>EntityManagerFactory:</b> Creates {@code EntityManager} instances
 *       used to manage persistent entities in the Java Persistence API (JPA) context.
 *       <ul>
 *         <li>JPA vendor adapter: typically {@code HibernateJpaVendorAdapter},
 *             but others exist (e.g., Apache OpenJPA, EclipseLink).</li>
 *         <li>DDL options: {@code create}, {@code update}, {@code validate}, {@code none}.</li>
 *         <li>Hibernate options: {@code show_sql}, {@code format_sql}, etc.</li>
 *       </ul>
 *   </li>
 *   <li><b>TransactionManager:</b> Coordinates transactions between the
 *       {@code EntityManager} and the underlying database to ensure data consistency.</li>
 * </ul>
 */

@Configuration
@EnableJpaRepositories(basePackages = "dev.duc.tlmse.database.repository")
public class DatasourceConfig {

//    this way to configuration by get value from application.yaml
//    @Bean
//    @ConfigurationProperties("spring.datasource")
//    public DataSource getDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    /**
     * Manual config datasource, other way get config from applicaiton.yaml
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/oauth2");
        dataSource.setUsername("postgres");
        dataSource.setPassword("sumo6842");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("dev.duc.tlmse.database.entity");

        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, Object> jpaProperties = new HashMap<>();

        jpaProperties.put("hibernate.show_sql", true);
        jpaProperties.put("hibernate.format_sql", true);
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "validate");
        factoryBean.setJpaPropertyMap(jpaProperties);
        factoryBean.setJpaPropertyMap(jpaProperties);
        return factoryBean;

    }

    @Bean
    public TransactionManager getTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
