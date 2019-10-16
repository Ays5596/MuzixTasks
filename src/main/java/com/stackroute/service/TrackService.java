package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public Track updateTrack(Track track) throws TrackNotFoundException;

    public void deleteTrack(Track track) throws TrackNotFoundException;

    public List<Track> getAllTracks() throws NullPointerException;

    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException;
}
