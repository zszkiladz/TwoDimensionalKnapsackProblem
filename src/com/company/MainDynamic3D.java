package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainDynamic3D {

    private static final List<Soldier> SOLDIERS = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = "in5.txt";
        Roman roman = readInput(fileName);

        //printSoldiers();

        int[][][] table = new int[SOLDIERS.size() + 1][roman.supplies + 1][roman.entertainment + 1];

        for (int i = 0; i < SOLDIERS.size(); i++) {
            int strength = SOLDIERS.get(i).strength;
            int supplies = SOLDIERS.get(i).supplies;
            int entertainment = SOLDIERS.get(i).entertainment;

            for (int j = 0; j < table[0].length; j++) {
                for (int k = 0; k < table[0][0].length; k++) {
                    table[i + 1][j][k] = table[i][j][k];
                }
            }

            for (int j = supplies; j <= roman.supplies; j++) {
                for (int k = entertainment; k <= roman.entertainment; k++) {
                    table[i + 1][j][k] = Math.max(strength + table[i][j - supplies][k - entertainment], table[i][j][k]);
                }
            }
        }


        List<Integer> takenSoldiers = new ArrayList<>();

        int supplies = roman.supplies;
        int entertainment = roman.entertainment;

        for (int i = SOLDIERS.size(); i > 0 && entertainment > 0 && supplies > 0; i--) {
            if (table[i][supplies][entertainment] > table[i - 1][supplies][entertainment]) {
                takenSoldiers.add(i);
                supplies = supplies - SOLDIERS.get(i-1).supplies;
                entertainment = entertainment - SOLDIERS.get(i-1).entertainment;
            }
        }

        takenSoldiers.sort(Integer::compareTo);

        System.out.println("Team strength: " + table[SOLDIERS.size()][roman.supplies][roman.entertainment]);
        for (Integer takenSoldier : takenSoldiers) {
            System.out.print(takenSoldier + " ");
        }
    }

    private static void printSoldiers() {
        for (int i = 0; i < SOLDIERS.size(); i++) {
            Soldier soldier = SOLDIERS.get(i);
            System.out.println(String.format("%3d", (i + 1)) + ". strength: " + String.format("%2d", soldier.strength) + ", supplies: " + String.format("%2d", soldier.supplies) + ", entertainment: " + String.format("%2d", soldier.entertainment));
        }
    }

    private static Roman readInput(String fileName) {
        int numberOfSoldiers;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String[] line = bufferedReader.readLine().split(" ");
            int supplies = Integer.parseInt(line[0]);
            int entertainment = Integer.parseInt(line[1]);
            Roman roman = new Roman(supplies, entertainment);

            numberOfSoldiers = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < numberOfSoldiers; i++) {
                line = bufferedReader.readLine().split(" ");
                int strength = Integer.parseInt(line[0]);
                int solderSupplies = Integer.parseInt(line[1]);
                int solderEntertainment = Integer.parseInt(line[2]);

                SOLDIERS.add(new Soldier(strength, solderSupplies, solderEntertainment));
            }
            return roman;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("file not found" + ex);
        } catch (IOException ex) {
            throw new RuntimeException("cannot read from file", ex);
        }
    }
}
