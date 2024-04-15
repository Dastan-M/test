package com.mygdx.game.Units;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Magicians extends Person {
    protected int mana;
    protected int maxMana;
    protected int healVal;
    protected int healPrice;
    protected int attackPrice;
    protected Magicians(String name, int priority, int health, int power, int agility, int defence, int distance, int mana, int x, int y) {
        super(name, priority, health, power, agility, defence, distance, x, y);
        this.mana = mana;
        this.maxMana = mana;
    }
    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        if (health <= 0)
            return;
        if (mana == 0) {
            mana += 5;
            return;
        }
        if (getDeads(friends) > 3) {
            doRes(friends);
        } else doHealed(friends);
    }

    @Override
    public String getInfo() {
        return "Magicians";
    }

    private void doRes(ArrayList<Person> friends) {
        if (mana > 50)
            return;
        Person pt = friends.stream()
                .filter(n -> n.health == 0)
                .sorted((n1, n2) -> n2.priority - n1.priority)
                .collect(Collectors.toList()).getFirst();
        pt.healed(Integer.MAX_VALUE);
        mana -= 50;
    }

    private void doHealed(ArrayList<Person> friends) {
        Person pt = null;
        int min = Integer.MIN_VALUE;
        for (Person friend : friends) {
            int hp = friend.getHealth();
            if (hp > 0 && hp < friend.maxHealth) {
                hp = hp * 100 / maxHealth;
                if (hp < min) {
                    min = hp;
                    pt = friend;
                }
            }
        }
        if (pt != null) {
            int temp = 10;
            mana -= 10;
            if (mana < 0) {
                temp += mana;
                mana = 0;
            }
            pt.healed(temp * 3);
        }
    }

    int getDeads(ArrayList<Person> body) {
        return (int) body.stream().filter(n -> n.health == 0).count();
    }

    public void attack(Person person) {

        person.health -= this.power;
        this.mana -= price("attack");
    }

    public void heal(Person person) {
        person.health += this.healVal;
        this.mana -= price("heal");
    }

    private int price(String action) {
        if (action == "heal") return healPrice;
        else if (action == "attack") return attackPrice;
        return 0;
    }
}
