package com.unosquare.example.service;

import com.unosquare.example.model.Fighter;

import java.util.HashMap;
import java.util.Map;

public class RosterBuilder {
    public static Map<Integer, Fighter> buildRoster(){
        HashMap<Integer, Fighter> roster = new HashMap<>();
        roster.put(1, new Fighter("Connor Mcgregor", 155));
        roster.put(2, new Fighter("Khabib Nurmagomedov", 200));
        roster.put(3, new Fighter("Tonny Ferguson", 170));
        return roster;
    }

    public static void createNewFighter(Map<Integer, Fighter> roster, Fighter fighter) {
        int lastId = roster.size();
        roster.put(lastId + 1, fighter);
    }
    public static boolean updateFighterInfo(Map<Integer, Fighter> roster, Integer id, Fighter fighter){
        if(roster.containsKey(id)){
            roster.remove(id);
            roster.put(id, fighter);
            return true;
        }else{
            return false;
        }
    }
    public static boolean deleteFighterInfo(Map<Integer, Fighter> roster, Integer id){
        if(roster.containsKey(id)){
            roster.remove(id);
            return true;
        }else{
            return false;
        }
    }

}
