package com.company;

import java.util.List;

public class Result {
    private int value;
    private List<Integer> takenThingIndexes;

    public Result(int value, List<Integer> takenThingIndexes) {
        this.value = value;
        this.takenThingIndexes = takenThingIndexes;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getTakenThingIndexes() {
        return takenThingIndexes;
    }

    @Override
    public String toString() {
        return "Result{" +
                "value=" + value +
                ", takenThingIndexes=" + takenThingIndexes +
                '}';
    }
}
