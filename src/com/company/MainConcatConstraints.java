package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainConcatConstraints {
    private static final List<Soldier> SOLDIERS = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = "in1.txt";
        Roman roman = readInput(fileName);

        for (int i = 0; i < SOLDIERS.size(); i++) {
            Soldier soldier = SOLDIERS.get(i);
            System.out.println(String.format("%3d", (i + 1)) + ". strength: " + String.format("%2d", soldier.strength) + ", supplies: " + String.format("%2d", soldier.supplies) + ", entertainment: " + String.format("%2d", soldier.entertainment));
        }

        int[][] tab = new int[SOLDIERS.size() + 1][roman.temp + 1];

        for (int i = 0; i < SOLDIERS.size(); i++) {
            int weight = SOLDIERS.get(i).temp;
            int strength = SOLDIERS.get(i).strength;

            if (weight >= 0) System.arraycopy(tab[i], 0, tab[i + 1], 0, roman.temp);

            for (int j = weight; j <= roman.temp; j++) {
                if (weight % 100 > j % 100 && weight / 100 > j / 100) {
                    tab[i + 1][j] = tab[i][j];
                }
                if (weight % 100 < j % 100 && weight / 100 < j / 100) {
                    tab[i + 1][j] = Math.max(strength + tab[i][j - weight], tab[i][j]);
                }
            }
        }

        List<Integer> takenThings = new ArrayList<>();
        int weight = roman.temp;

        for (int i = SOLDIERS.size(); i > 0 && weight > 0; i--) {
            if (tab[i][weight] > tab[i - 1][weight]) {
                takenThings.add(i);
                weight = weight - SOLDIERS.get(i - 1).temp;
            }
        }
        takenThings.sort(Integer::compareTo);

        for (int[] ints : tab) {
            for (int anInt : ints) {
                System.out.print(String.format("%2d", anInt) + " ");
            }
            System.out.println();
        }

        System.out.println(tab[tab.length - 1][tab[0].length - 1]);

        for (Integer takenThing : takenThings) {
            System.out.print(String.format("%d", takenThing) + " ");
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
