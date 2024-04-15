package com.mygdx.game.Units;

public class Pikeman extends Warriors {
    public Pikeman(String name, int x, int y) {

        super(name, 2, 100, 100, 50, 20, 10, x, y);
    }
    @Override
    public String toString() {
        return "[Pikeman]{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }
    @Override
    public String getInfo() {
        return "Pikeman " + definition;
    }
}
