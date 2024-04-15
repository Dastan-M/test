package com.mygdx.game.Units;

public class Sniper extends Shooters{
    private int arrowsNum;
    boolean inGame = true;
    public Sniper (String name, int x, int y) {

        super(name, 3, 100, 30, 30, 10, 16, 12, x, y);
    }
    @Override
    public String getInfo() {
        return "Sniper" + definition;
    }
    @Override
    public String toString() {
        return "[Sniper]{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }

}
