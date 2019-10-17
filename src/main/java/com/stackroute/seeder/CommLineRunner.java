package com.stackroute.seeder;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommLineRunner implements CommandLineRunner {
    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void run(String... args) throws Exception {
    trackRepository.save(new Track(2,"RockOn2","SHIT"));
    }
}
