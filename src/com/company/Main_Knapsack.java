package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main_Knapsack {
    public static void main(String[] args) {
        int weightKnapsack = 10;
        List<Thing> things = new ArrayList<>();
        things.add(new Thing(10, 5));
        things.add(new Thing(40, 4));
        things.add(new Thing(30, 6));
        things.add(new Thing(50, 3));
        int[][] tab = new int[things.size() + 1][weightKnapsack + 1];

        for (int i = 0; i < things.size(); i++) {
            int weight = things.get(i).weight;
            int price = things.get(i).price;

            if (weight >= 0) System.arraycopy(tab[i], 0, tab[i + 1], 0, weight);

            for (int j = weight; j <= weightKnapsack; j++) {
                tab[i + 1][j] = Math.max(price + tab[i][j - weight], tab[i][j]);
            }
        }

        List<Integer> takenThings = new ArrayList<>();
        int weight = weightKnapsack;

        for (int i = things.size(); i > 0 && weight > 0; i--) {
            if (tab[i][weight] > tab[i - 1][weight]) {
                takenThings.add(i);
                weight = weight - things.get(i - 1).weight;
            }
        }
        takenThings.sort(Integer::compareTo);

        printResult(tab, takenThings);
    }

    private static void printResult(int[][] tab, List<Integer> takenThings) {
        printTable(tab);
        System.out.println();
        System.out.println("TAKEN THINGS:");
        for (Integer takenThing : takenThings) {
            System.out.print(takenThing + " ");
        }
    }

    private static void printTable(int[][] tab) {
        System.out.print("   ");
        for (int i = 0; i < tab[0].length; i++) {
            System.out.print(String.format("%2d", i) + " ");
        }
        System.out.println();
        for (int i = 0; i <= tab[0].length; i++) {
            System.out.print("---");
        }
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            System.out.print(String.format("%2d", i) + "|");
            for (int j = 0; j < tab[0].length; j++) {
                System.out.print(String.format("%2d", tab[i][j]) + " ");
            }
            System.out.println();
        }
    }


}
