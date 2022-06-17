package de.jinx.smp_reborn.util;

public class Chance {
    //TODO: Change Chance! + maybe Chance in Parameters
    public static boolean hitChance(int chance){
        int random = (int)(Math.random() * 100 + 1);
        return random < chance;
    }
}
