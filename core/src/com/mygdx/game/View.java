package com.mygdx.game;

import com.mygdx.game.Main;

import java.util.Collections;
import com.mygdx.game.Units.*;
public class View {
    private static int step = 1;
    private static int l = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '┌')
                .replace('b', '┬')
                .replace('c', '┐')
                .replace('d', '├')
                .replace('e', '┼')
                .replace('f', '┤')
                .replace('g', '└')
                .replace('h', '┴')
                .replace('i', '┘')
                .replace('-', '─');
    }
    private static String getChar(int x, int y, Main main){
        String out = "| ";
        for (Person human: main.all) {
            if (human.getCoords()[0] == x && human.getCoords()[1] == y){
                if (human.getHealth() == 0) {
                    out = "|" + (AnsiColors.ANSI_RED + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (main.teamA.contains(human)) out = "|" + (AnsiColors.ANSI_GREEN + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                if (main.teamB.contains(human)) out = "|" + (AnsiColors.ANSI_BLUE + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view(Main main) {
        if (step == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        main.all.forEach((v) -> l = Math.max(l, v.toString().length()));
        System.out.print("_".repeat(l*2));
        System.out.println();
        System.out.print(top10 + "    ");
        System.out.print("Blue side");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l-9));
        System.out.println(":\tGreen side");
        for (int i = 0; i < 10; i++) {
            System.out.print(getChar(0, i, null));
        }
        System.out.print("|    ");
        System.out.print(main.teamB.get(0));
        tabSetter(main.teamB.get(0).toString().length(), l);
        System.out.println(main.teamA.get(0));
        System.out.println(midl10);

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(i, j, null));
            }
            System.out.print("|    ");
            System.out.print(main.teamB.get(i));
            tabSetter(main.teamB.get(i).toString().length(), l);
            System.out.println(main.teamA.get(i));
            System.out.println(midl10);
        }
        for (int j = 0; j < 10; j++) {
            System.out.print(getChar(9, j, null));
        }
        System.out.print("|    ");
        System.out.print(main.teamB.get(9));
        tabSetter(main.teamB.get(9).toString().length(), l);
        System.out.println(main.teamA.get(9));
        System.out.println(bottom10);
    }
}