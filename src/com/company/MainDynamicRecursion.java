package com.company;

import java.util.ArrayList;
import java.util.List;

public class MainDynamicRecursion {

    private static final List<Soldier> SOLDIERS = new ArrayList<>();
    private static final List<int[]> TAB = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = "in5.txt";
        Roman roman = MainDynamic3D.readInput(fileName);
        printData(roman);

        List<Soldier> hiredSoldiers = new ArrayList<>();

        int strength = getTheBestTeam(roman.supplies, roman.entertainment, SOLDIERS, hiredSoldiers);

        System.out.println();
        System.out.println("MAX STRENGTH: " + strength);
        System.out.print("SOLDIERS IN THE TEAM: ");
        for (int i = hiredSoldiers.size() - 1; i >= 0; i--) {
            Soldier rentSoldier = hiredSoldiers.get(i);
            System.out.print(SOLDIERS.indexOf(rentSoldier) + 1 + " ");
        }
    }

    private static int getTheBestTeam(int supplies, int entertainment, List<Soldier> soldiers, List<Soldier> hiredSoldiers) {
        if (soldiers.size() == 1) {
            Soldier soldier = soldiers.get(0);
            if (entertainment < 0 || supplies < 0 || soldier.entertainment > entertainment || soldier.supplies > supplies) {
                return -Integer.MAX_VALUE;
            } else {
                hiredSoldiers.add(soldier);
                return soldier.strength;
            }
        }

        Soldier lastSoldier = soldiers.get(soldiers.size() - 1);

        List<Soldier> soldiers2 = new ArrayList<>(soldiers);
        List<Soldier> rentSoldiers2 = new ArrayList<>();
        soldiers2.remove(lastSoldier);
        rentSoldiers2.add(lastSoldier);
        int strength2 = lastSoldier.strength + getTheBestTeam(supplies - lastSoldier.supplies, entertainment - lastSoldier.entertainment, soldiers2, rentSoldiers2); //with last

        List<Soldier> soldiers1 = new ArrayList<>(soldiers);
        List<Soldier> rentSoldiers1 = new ArrayList<>();
        soldiers1.remove(lastSoldier);
        int strength1 = getTheBestTeam(supplies, entertainment, soldiers1, rentSoldiers1); //without last

        if (strength1 > strength2) {
            hiredSoldiers.addAll(rentSoldiers1);
            return strength1;
        } else {
            hiredSoldiers.addAll(rentSoldiers2);
            return strength2;
        }
    }

    private static void printData(Roman roman) {
        System.out.println("Roman can provide " + roman.supplies + " supplies and " + roman.entertainment + " entertainments.");
        System.out.println("SOLDIERS:");
        for (int i = 0; i < SOLDIERS.size(); i++) {
            Soldier soldier = SOLDIERS.get(i);
            System.out.println((i + 1) + ". Strength: " + soldier.strength + ", supplies: "
                    + soldier.supplies + ", entertainments: " + soldier.entertainment);
        }
    }
}
