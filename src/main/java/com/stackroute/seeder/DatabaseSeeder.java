/*
package com.stackroute.seeder;

import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DatabaseSeeder {
    private Logger logger;
    private TrackRepository trackRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(TrackRepository trackRepository, JdbcTemplate jdbcTemplate) {
        this.trackRepository = trackRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        seedTrackTable();
    }
    private void seedTrackTable(){

    }
}
*/
