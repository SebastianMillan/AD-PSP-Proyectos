package com.salesianostriana.dam.ConfigJPA_CursoOW;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DBConfig {



    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, DataSource dataSource){
        Map<String, Object> props = new HashMap<>();

        props.put("hibernate.hbm2ddl.auto","create");
        props.put("hibernate.show_sql","true");
        props.put("hibernate.format_sql","true");
        props.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        props.put("hibernate.session.events.log.LOG_QUERIES_SLOWER_THAN_MS","1");


    }

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:./db/basededatos;DB_CLOSE_ON_EXIT=FALSE;")
                .username("sa")
                .password("")
                .build();
    }
}
