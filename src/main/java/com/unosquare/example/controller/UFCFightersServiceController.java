package com.unosquare.example.controller;

import com.unosquare.example.model.Fighter;
import com.unosquare.example.service.RosterBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UFCFightersServiceController {

    private static Map<Integer, Fighter> ufcRoster = RosterBuilder.buildRoster();

    @RequestMapping(value = "/ufcRoster")
    public ResponseEntity<Object> getUfcRoster(){
        return new ResponseEntity<>(ufcRoster.values(), HttpStatus.OK);
    }
    @RequestMapping(value = "/ufcRoster", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewFighter(@RequestBody Fighter fighter){
        RosterBuilder.createNewFighter(ufcRoster, fighter);
        return new ResponseEntity<>(ufcRoster.values(), HttpStatus.OK);
    }
    @RequestMapping(value = "/ufcRoster/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateFighterInfo(@PathVariable("id")Integer id, @RequestBody Fighter fighter){
        return RosterBuilder.updateFighterInfo(ufcRoster, id, fighter)?
                new ResponseEntity<>(ufcRoster.values(), HttpStatus.OK):
                new ResponseEntity<>("Id does not exist", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/ufcRoster/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> updateFighterInfo(@PathVariable("id")Integer id){
        return RosterBuilder.deleteFighterInfo(ufcRoster, id)?
                new ResponseEntity<>(ufcRoster.values(), HttpStatus.OK):
                new ResponseEntity<>("Id does not exist, I could not delete it!", HttpStatus.NOT_FOUND);
    }
}