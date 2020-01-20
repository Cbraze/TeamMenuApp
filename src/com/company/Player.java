package com.company;

public class Player {
    private String name;
    private String position;
    private String specialty;
    private String number;

    public Player(String name, String position, String specialty, String number) {
        this.name = name;
        this.position = position;
        this.specialty = specialty;
        this.number = number;
    }

    public void describe() {
        System.out.println("Player : " + name + "\tPosition: " + position + "\tSpecialty: " + specialty + "\tNumber: " + number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
