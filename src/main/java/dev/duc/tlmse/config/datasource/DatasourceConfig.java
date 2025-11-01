package dev.duc.tlmse.config.datasource;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;

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
public class DatasourceConfig {

//    this way to configuration by get value from application.yaml
//    @Bean
//    @ConfigurationProperties("spring.datasource")
//    public DataSource getDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    /**
     * Manual config datasource, other way get config from applicaiton.yaml
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
    public EntityManagerFactory getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("dev.duc.tlmse.database.entity");

        factoryBean.setJpaPropertyMap(new HashMap<>() {{
            put("datasource.jpa.hibernate.ddl", "validate");
            put("datasource.jpa.hibernate.show-sql", "true");
            put("datasource.jpa.hibernate.format-sql", "true");
            put("spring.data.jbdc.dialect", "postgresq");
        }});

        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return factoryBean.getObject();
    }

    @Bean
    public JpaTransactionManager getTransactionManager() {
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(getEntityManagerFactory());
       return transactionManager;
    }

}
