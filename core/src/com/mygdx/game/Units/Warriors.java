package com.mygdx.game.Units;

import java.util.ArrayList;

public class Warriors extends Person {
    protected Warriors(String name, int priority, int health, int power, int agility, int defence, int distance, int x, int y) {
        super(name, priority, health, power, agility, defence, distance, x, y);
    }

    public boolean isMove(Position pos, ArrayList<Person> persons) {

        for (Person hero : persons) {
            if (hero.position.equals(pos))
                return false;
        }
        return true;
    }

    public void attack(Person target, boolean isMove) {
//        System.out.println(name + " attacked " + person.name);
        int damage = this.power;
        target.health -= this.power;
        if(isMove) damage /= 2;
        int res = target.getDamage(damage);
        definition = definition + "attack" + target.name + "set" + res + "damage";
//        System.out.println(" and gives " + res + " damage.");
    }

    public void move(Person target, ArrayList<Person> friends) {
        int[] px = {1, 0, -1, 0};
        int[] py = {0, 1, 0, -1};
        Position newPos = new Position(position.getX(), position.getY());
        int minIdx = -1;
        float minDist = Float.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            newPos.setXY(position.getX() + px[i], position.getY() + py[i]);
            if (isMove(newPos, friends)) {
                float dist = position.fastDistance(target.position, px[i], py[i]);
                if (dist < minDist) {
                    minIdx = i;
                    minDist = dist;
                }
            }
        }
        if (minIdx != -1) {
            return;
//            position.increment(px[minIdx], py[minIdx]);
//            System.out.println(name + ": moved to (" + position.getX() + ", " + position.getY() + ")");
        }
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        Person target = this.findNearestEnemy(enemies);
        if (health <= 0 || target == null)
            return;
        if (position.distanceTo(target.position) < 1.5f)
            attack(target, false);
        else {
            move(target, friends);
            if (position.distanceTo(target.position) < 1.5f) {
                attack(target, true);
            }
        }
    }

    @Override
    public String getInfo() {
        return "Warriors";
    }
}
