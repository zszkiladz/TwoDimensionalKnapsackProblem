package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainDynamic3D {
    private static final List<Soldier> SOLDIERS = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = "inMed.txt";
        String outputName = "out.txt";
        Roman roman = readInput(fileName);

        int[][][] table = getFilledTable(roman);
        List<Integer> takenSoldiers = getTeam(table);
        int teamStrength = table[SOLDIERS.size()][roman.supplies][roman.entertainment];

        printResult(takenSoldiers, teamStrength);
        writeResult(takenSoldiers, teamStrength);
    }

    static Roman readInput(String fileName) {
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

    private static int[][][] getFilledTable(Roman roman) {
        int numberOfSoldiers = SOLDIERS.size();
        int romanSupplies = roman.supplies;
        int romanEntertainment = roman.entertainment;

        int[][][] table = new int[numberOfSoldiers + 1][romanSupplies + 1][romanEntertainment + 1];

        for (int i = 0; i < numberOfSoldiers; i++) {
            int strength = SOLDIERS.get(i).strength;
            int supplies = SOLDIERS.get(i).supplies;
            int entertainment = SOLDIERS.get(i).entertainment;

            //najpierw przepisywane są wartosci z poprzedniego zolnierza
            for (int j = 0; j <= romanSupplies; j++) {
                if (romanEntertainment + 1 >= 0) {
                    System.arraycopy(table[i][j], 0, table[i + 1][j], 0, romanEntertainment + 1);
                }
            }

            //wlasciwe uzupelnienie tabeli dla danego zolnierza
            for (int j = supplies; j <= romanSupplies; j++) {
                for (int k = entertainment; k <= romanEntertainment; k++) {
                    table[i + 1][j][k] = Math.max(strength + table[i][j - supplies][k - entertainment], table[i][j][k]);
                }
            }
        }

        return table;
    }

    private static List<Integer> getTeam(int[][][] table) {
        int supplies = table[0].length - 1;
        int entertainment = table[0][0].length - 1;
        List<Integer> takenSoldiers = new ArrayList<>();

        for (int i = SOLDIERS.size(); i > 0 && entertainment > 0 && supplies > 0; i--) {
            if (table[i][supplies][entertainment] > table[i - 1][supplies][entertainment]) {
                takenSoldiers.add(i);
                supplies = supplies - SOLDIERS.get(i - 1).supplies;
                entertainment = entertainment - SOLDIERS.get(i - 1).entertainment;
            }
        }
        takenSoldiers.sort(Integer::compareTo);
        return takenSoldiers;
    }

    private static void writeOutput(String text, String path) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path))) {
            fileWriter.write(text);
        } catch (IOException ex) {
            throw new RuntimeException("cannot write to file", ex);
        }
    }

    private static void printResult(List<Integer> takenSoldiers, int teamStrength) {
        System.out.println("Team strength: " + teamStrength);
        System.out.println("Taken soldiers:");
        for (Integer takenSoldier : takenSoldiers) {
            System.out.print(takenSoldier + " ");
        }
    }

    private static void writeResult(List<Integer> takenSoldiers, int teamStrength) {
        StringBuilder sb = new StringBuilder(String.valueOf(teamStrength));
        sb.append("\n");
        for (Integer takenSoldier : takenSoldiers) {
            sb.append(takenSoldier).append(" ");
        }

        writeOutput(sb.toString(), "out.txt");
    }
}
