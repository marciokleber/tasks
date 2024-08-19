package com.github.marciokleber.tasks.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setLocations("classpath:db/migration");
        flyway.setDataSource(dataSource);
        return flyway;
    }
}
