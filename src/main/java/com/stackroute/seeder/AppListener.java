package com.stackroute.seeder;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private TrackRepository trackRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    trackRepository.save(new Track(1,"RockOn","FAB"));
    }
}
