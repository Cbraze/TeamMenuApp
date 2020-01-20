package com.company;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Team> teams = new ArrayList<Team>();

    public static void main(String[] args) {

//        Player p1 = new Player("Nick Bosa", "defensive end", "47 tackles", "97");
//        Player p2 = new Player("Jimmy G", "quarterback", "6946 ytd passing yard", "10");
//        Team team = new Team("49ers");
//        team.addPlayer(p1);
//        team.addPlayer(p2);
//        team.describe();
//
//        team.removePlayer("Nick Bosa");
//        team.describe();

        /*
        this was all testing, now for the real app!
        the exceptions in all these methods are to keep the app running if there is an exceptions so it doesnt crash
         */
        int decision = 0;


        while (true) {
            printOptions();
            decision = scanner.nextInt();
            if (decision == 1) {
                teams.add(createNewTeam());
            } else if (decision == 2) {
                addPlayerToTeam();
            } else if (decision == 3) {
                removePlayerFromTeam();
            } else if (decision == 4) {
                describeTeam();
            } else {
                System.out.println("Please pick valid option.");
            }
        }
    }

    private static void printOptions() {
        System.out.println("1) Create New Team.");
        System.out.println("2) Add New Player to Team.");
        System.out.println("3) Remove Player from Team.");
        System.out.println("4) View Team info");
    }

    private static void describeTeam() {
        printTeamNames();
        System.out.println("Which team would you like to learn about? ");
        String teamName = scanner.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.describe();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static Team createNewTeam() {
        System.out.print("Enter name of the team you want to create: ");
        String name = scanner.next();
        return new Team(name);
    }

    private static void addPlayerToTeam() {
        printTeamNames();
        System.out.print("Enter the name of team you wish to add a player to:");
        String teamName = scanner.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.addPlayer(createNewPlayer());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void removePlayerFromTeam() {
        printTeamNames();
        System.out.print("Enter the name of team you wish to remove a player from");
        String teamName = scanner.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.describe();
            System.out.println("Which player would you like to remove? ");
            String playerName = scanner.next();
            foundTeam.removePlayer(playerName);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static Player createNewPlayer() {
        System.out.print("Enter player name: ");
        String name = scanner.next();
        scanner.nextLine();

        System.out.print("Enter player position: ");
        String position = scanner.next();
        scanner.nextLine();
        System.out.print("Enter player specialty: ");
        String specialty = scanner.next();
        scanner.nextLine();
        System.out.print("Enter player number: ");
        String number = scanner.next();
        scanner.nextLine();
        return new Player(name, position, specialty, number);
    }

    private static void printTeamNames() {
        for (Team team : teams) {
            System.out.println(team.getName());
        }
    }

    private static Team findTeamByName(String name) throws Exception {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        throw new Exception("Team not found." + name);
    }
}
