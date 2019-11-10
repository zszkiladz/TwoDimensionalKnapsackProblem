package com.company;

import java.util.Objects;

public class Soldier {
    int strength;
    int supplies;
    int entertainment;
    int temp;

    public Soldier(int strength, int supplies, int entertainment) {
        this.strength = strength;
        this.supplies = supplies;
        this.entertainment = entertainment;
        temp = supplies * 100 + entertainment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier soldier = (Soldier) o;
        return strength == soldier.strength &&
                supplies == soldier.supplies &&
                entertainment == soldier.entertainment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, supplies, entertainment);
    }
}
