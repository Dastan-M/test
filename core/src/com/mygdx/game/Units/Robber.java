package com.mygdx.game.Units;

public class Robber extends Warriors {
    public Robber(String name, int x, int y) {

        super(name, 2, 100, 100, 50, 20, 10, x, y);
    }
    @Override
    public String toString() {
        return "[Robber]{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }
    @Override
    public String getInfo() {
        return "Robber " + definition;
    }
}
