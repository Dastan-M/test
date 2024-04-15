package com.mygdx.game.Units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<Person> enemies, ArrayList<Person> friends);
    String getInfo();

}
