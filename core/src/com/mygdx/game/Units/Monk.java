package com.mygdx.game.Units;

public class Monk extends Magicians {
    public Monk (String name, int x, int y){

        super(name, 1, 100, 30, 10, 1, 10, 100, x, y);
    }

    @Override
    public String toString() {
        return "[Monk]{" + name + " ❤=" + health + ", " + position.toString() + '}';
    }
    @Override
    public String getInfo() {
        return "Monk";
    }
}
