package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dummy")
//@Qualifier("ServiceImpl")
public class TrackDummyServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackDummyServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId()))
            throw new TrackAlreadyExistsException("Track Already Exists");
        Track track1 = trackRepository.save(track);
        return track1;
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        Track track1 = new Track();
        if(!trackRepository.existsById(track.getTrackId()))
            throw new TrackNotFoundException("Track Not Found");
        else {
            track1 = trackRepository.getOne(track.getTrackId());
            track1.setTrackComment(track.getTrackComment());
            trackRepository.save(track1);}
        return track1;
    }

    @Override
    public void deleteTrack(Track track) throws TrackNotFoundException{
        if(!trackRepository.existsById(track.getTrackId()))
            throw new TrackNotFoundException("Track Not Found");
        else
            trackRepository.delete(track);
    }

    @Override
    public List<Track> getAllTracks() throws NullPointerException{
        return trackRepository.findAll();
    }

    @Override
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
        List<Track> trackList = trackRepository.findByName(trackName);
        if(trackList==null)
            throw new TrackNotFoundException("Track Name Not Found");
        return trackList;
    }
}
