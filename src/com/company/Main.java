package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Knapsack knapsack = new Knapsack(20, 10);
        knapsack.add(new Thing(3, 4, 2));
        knapsack.add(new Thing(3, 8, 3));
        knapsack.addAll(Arrays.asList(
                new Thing(4, 2, 7),
                new Thing(5, 1, 6),
                new Thing(3, 5, 4),
                new Thing(2, 3, 1))
        );

        Result result = knapsack.getResult();

        System.out.println(result);
    }
}
