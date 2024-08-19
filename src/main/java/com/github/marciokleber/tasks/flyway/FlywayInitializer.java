package com.github.marciokleber.tasks.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class FlywayInitializer {

    @Autowired
    private final Flyway flyway;

    public FlywayInitializer(Flyway flyway) {
        this.flyway = flyway;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        flyway.setBaselineOnMigrate(true);
        flyway.migrate();
    }

}
