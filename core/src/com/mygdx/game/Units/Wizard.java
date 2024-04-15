package com.mygdx.game.Units;

public class Wizard extends Magicians{
    public Wizard(String name, int x, int y) {
        super(name, 1, 100, 40, 10, 1, 8, 100, x, y);
    }
    @Override
    public String toString() {
        return "[Wizard]{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }
    @Override
    public String getInfo() {
        return "Wizard";
    }
}
