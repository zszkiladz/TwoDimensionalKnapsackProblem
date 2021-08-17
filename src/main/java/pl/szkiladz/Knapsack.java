package pl.szkiladz;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private final int constraint1;
    private final int constraint2;
    private final List<Thing> things = new ArrayList<>();

    public Knapsack(int constraint1, int constraint2) {
        this.constraint1 = constraint1;
        this.constraint2 = constraint2;
    }

    public void add(Thing thing) {
        this.things.add(thing);
    }

    public void addAll(List<Thing> things) {
        this.things.addAll(things);
    }

    public void remove(Thing thing) {
        things.remove(thing);
    }

    public void remove(int index) {
        things.remove(index);
    }

    public Result getResult() {
        int[][][] table = getFilledTable();
        int value = getMaxValue(table);
        List<Integer> list = getTakenThingsIndexes(table);

        return new Result(value, list);
    }

    private int getMaxValue(int[][][] table) {
        return table[things.size()][constraint1][constraint2];
    }

    private List<Integer> getTakenThingsIndexes(int[][][] table) {
        int constraintKnapsack1 = constraint1;
        int constraintKnapsack2 = constraint2;
        List<Integer> takenThings = new ArrayList<>();

        for (int i = things.size(); i > 0 && constraintKnapsack2 > 0 && constraintKnapsack1 > 0; i--) {
            if (table[i][constraintKnapsack1][constraintKnapsack2] > table[i - 1][constraintKnapsack1][constraintKnapsack2]) {
                takenThings.add(i);
                constraintKnapsack1 = constraintKnapsack1 - things.get(i - 1).getConstraint1();
                constraintKnapsack2 = constraintKnapsack2 - things.get(i - 1).getConstraint2();
            }
        }
        takenThings.sort(Integer::compareTo);
        return takenThings;
    }

    private int[][][] getFilledTable() {
        int[][][] table = new int[things.size() + 1][constraint1 + 1][constraint2 + 1];

        for (int i = 0; i < things.size(); i++) {
            int thingValue = things.get(i).getValue();
            int thingConstraint1 = things.get(i).getConstraint1();
            int thingConstraint2 = things.get(i).getConstraint2();

            //rewriting the values from the previous line
            for (int j = 0; j <= constraint1; j++) {
                if (constraint2 + 1 >= 0) {
                    System.arraycopy(table[i][j], 0, table[i + 1][j], 0, constraint2 + 1);
                }
            }
            //completing the line
            for (int j = thingConstraint1; j <= constraint1; j++) {
                for (int k = thingConstraint2; k <= constraint2; k++) {
                    table[i + 1][j][k] = Math.max(thingValue + table[i][j - thingConstraint1][k - thingConstraint2], table[i][j][k]);
                }
            }
        }
        return table;
    }

    public int getConstraint1() {
        return constraint1;
    }

    public int getConstraint2() {
        return constraint2;
    }
}
