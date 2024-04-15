package com.mygdx.game.Units;

import java.util.ArrayList;

public class Shooters extends Person {
    protected int arrowsNum;
    protected boolean inGame = true;
    protected Shooters(String name, int priority, int health, int power, int agility, int defence, int distance, int arrowsNum, int x, int y) {
        super(name, priority, health, power, agility, defence, distance, x, y);
        this.arrowsNum = arrowsNum;
    }

    public int getArrowsNum() {
        return arrowsNum;
    }

    public void attack(Person person) {
//        System.out.println(name + " attacked " + person.name);
        arrowsNum--;
        int damage = this.power;
        person.health -= this.power;
        int res = person.getDamage(damage);
//        System.out.println(" and gives " + res + " damage.");
    }

    public boolean isInGame() {
        return this.arrowsNum != 0;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        if (health <= 0 && arrowsNum <= 0) {
//            if (arrowsNum <= 0){
//                System.out.println(name + ": no arrows!");
//            }
            return;
        }
        Person target = this.findNearestEnemy(enemies);
        if (target != null) {
            shot(target);
        }

    }

    @Override
    public String getInfo() {
        return "Shooters";
    }

    public void setArrowsNum(int arrowsNum) {
        this.arrowsNum = arrowsNum;
    }

    protected void shot(Person target) {
        arrowsNum--;
        float dist = position.distanceTo(target.position);
        int damage = getRound(power, 10);
        if (dist == distance)
            damage *= 1.1f;
        boolean critical = (this.agility / 2.5) >= rnd.nextInt(100);
        if (critical)
            damage *= 2.0f;
        target.getDamage(damage);
    }
}
