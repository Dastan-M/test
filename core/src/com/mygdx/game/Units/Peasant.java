package com.mygdx.game.Units;

import java.util.ArrayList;

public class Peasant extends Person {
    private int arrowsNum;
    boolean inGame = true;
    private static final int FULL_BAG = 20;
    private final int bag;
    public Peasant(String name, int x, int y) {super(name, 0, 100, 30, 20, 1, 1, x, y);
        bag = 0;
    }
    public void giveArrows(int val) {
        this.arrowsNum -= val;
        if (!isInGame()) {
            inGame = false;
        }
    }

    public boolean isInGame() {
        return this.arrowsNum != 0;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        Person pt = null;
        int min = Integer.MIN_VALUE;
        if (health <= 0)
            return;
        for (Person friend : friends) {
            if (friend instanceof Shooters) {
                if (((Shooters) friend).getArrowsNum() < min) {
                    min = ((Shooters) friend).getArrowsNum();
                    pt = friend;
                }
            }
        }
        if (pt != null){
            System.out.println("Give arrows "+ pt);
            ((Shooters)pt).setArrowsNum(min + 1);
        }
    }
    @Override
    public String toString() {
        return "[Peasant]{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }
    @Override
    public String getInfo() {return "Peasant";}
}
