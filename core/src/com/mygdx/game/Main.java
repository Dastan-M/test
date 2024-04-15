package com.mygdx.game;

import com.mygdx.game.Units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
    public ArrayList<Person> teamA = new ArrayList<>();
    public ArrayList<Person> teamB = new ArrayList<>();
    public ArrayList<Person> all = new ArrayList<>();

    public Main() {
        init();
    }
    public void init() {
        teamA = createTeam(10, 0);
        teamB = createTeam(10, 0);
        all.addAll(teamA);
        all.addAll(teamB);
        all.sort((o1, o2) -> Integer.compare(o2.priority, o1.priority));
//        all.sort(new PrioritySort());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startGame();
    }
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            View.view(this);
            for (Person hero : this.all) {
                if (this.teamA.contains(hero)) {
                    hero.step(this.teamB, this.teamA);
                } else {
                    hero.step(this.teamA, this.teamB);
                }
            }
            scanner.nextLine();
            if (!isAlive(this.teamA)) {
                System.out.println("teamB is winner!");
                break;
            }
            if (!isAlive(this.teamB)) {
                System.out.println("teamA is winner!");
                break;
            }
        }
    }

    private static boolean isAlive(ArrayList<Person> team) {
        for (Person person : team) {
            if (person.getHealth() > 0)
                return true;
        }
        return false;
    }

    public ArrayList<Person> createTeam(int val, int num){
        ArrayList<Person> team = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int newHero = new Random().nextInt(4);
            switch (newHero) {
                case 0:
                    team.add(new Crossbowman(getName(), 0, i));
                    break;
                case 1:
                    team.add(new Pikeman(getName(), 0, i));
                    break;
                case 2:
                    team.add(new Wizard(getName(), 0, i));
                    break;
                default:
                    team.add(new Peasant(getName(), 0, i));
                    break;
            }
        }
        for (int i = 0; i < 10; i++) {
            int newHero = new Random().nextInt(4);
            switch (newHero) {
                case 0:
                    team.add(new Sniper(getName(), 9, i));
                    break;
                case 1:
                    team.add(new Robber(getName(),9, i));
                    break;
                case 2:
                    team.add(new Monk(getName(), 9, i));
                    break;
                default:
                    team.add(new Peasant(getName(), 9, i));
                    break;
            }
        }
        return team;
    }
    public String step(){
        int deadCountTeamA = 0;
        int deadCountTeamB = 0;
        boolean endGame = false;
        for (Person item : all) {
            if (teamA.contains(item)){
                item.step(teamB, teamA);
            }else
                item.step(teamA, teamB);
        }
        for (Person item : teamA) {
            if (item.getHealth() <= 0){
                deadCountTeamA +=1;
            }
            if (deadCountTeamA == teamA.size()){
                return  "TeamB wins!";
            }
        }
        for (Person item : teamB) {
            if (item.getHealth() <= 0){
                deadCountTeamB +=1;
            }
            if (deadCountTeamB == teamB.size()){
                return  "TeamA wins!";
            }
        }return null;
    }
}
