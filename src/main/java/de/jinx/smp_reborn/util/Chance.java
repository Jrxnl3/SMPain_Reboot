package de.jinx.smp_reborn.util;

public class Chance {
    public static boolean hitChance(int chance){
        int random = (int)(Math.random() * 100);
        return random < chance;
    }
    public static double rdmNr(double min,double max){
        return (Math.random() * max + min);
    }
}
