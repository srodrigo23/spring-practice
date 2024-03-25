package com.unosquare.example.model;

public class Fighter {
    private String name;
    private double weight;
    private String division;

    public Fighter(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.division = determineDivision(this.weight);
    }

    private String determineDivision(double weightInPounds){
        if (weightInPounds >=125 && weightInPounds < 135)
            return "Flyweight";
        else if (weightInPounds >=135 && weightInPounds < 145) {
            return "Bantamweight";
        } else if (weightInPounds >=145 && weightInPounds < 155) {
            return "Featherweight";
        } else if (weightInPounds >=155 && weightInPounds < 170) {
            return "Lightweight";
        } else if (weightInPounds >=170 && weightInPounds < 185) {
            return "Welterweight";
        } else if (weightInPounds >=185 && weightInPounds < 205) {
            return "Middleweight";
        } else if (weightInPounds >=205 && weightInPounds < 265) {
            return "Light heavyweight";
        }else if(weightInPounds >= 265){
            return "Heavyweight";
        }else{
            return "No ranked";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
