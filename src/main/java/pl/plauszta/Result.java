package pl.plauszta;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return value == result.value &&
                Objects.equals(takenThingIndexes, result.takenThingIndexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, takenThingIndexes);
    }
}
