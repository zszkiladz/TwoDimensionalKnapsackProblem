package pl.plauszta;

import java.util.Objects;

public class Thing {
    private final int value;
    private final int constraint1;
    private final int constraint2;

    public Thing(int value, int constraint1, int constraint2) {
        this.value = value;
        this.constraint1 = constraint1;
        this.constraint2 = constraint2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return value == thing.value
                && constraint1 == thing.constraint1
                && constraint2 == thing.constraint2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, constraint1, constraint2);
    }

    public int getValue() {
        return value;
    }

    public int getConstraint1() {
        return constraint1;
    }

    public int getConstraint2() {
        return constraint2;
    }
}
