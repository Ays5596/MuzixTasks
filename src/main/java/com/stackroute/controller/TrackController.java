package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

    TrackService trackService;

    public TrackController(/*@Qualifier("ServiceImpl")*/ TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
//        try{
        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
//          }
//        catch (TrackAlreadyExistsException ex){
//          responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//          }
        return responseEntity;
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
//        try{
        trackService.updateTrack(track);
        responseEntity = new ResponseEntity<String>("Updated", HttpStatus.CREATED);
//        }
//        catch (TrackNotFoundException ex){
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//        }
        return responseEntity;
    }

    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
//        try{
        trackService.deleteTrack(track);
        responseEntity = new ResponseEntity<String>("Deleted", HttpStatus.CREATED);
//        }
//        catch (TrackNotFoundException ex){
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @GetMapping("track/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackName) throws TrackNotFoundException {
        return new ResponseEntity<List<Track>>(trackService.getTrackByName(trackName), HttpStatus.OK);
    }
}
