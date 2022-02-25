package org.example;

import java.util.Objects;

public class Paair {
    String str;
    int number;

    public Paair(String str, int number) {
        this.str = str;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paair paair = (Paair) o;
        return number == paair.number && Objects.equals(str, paair.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, number);
    }

    @Override
    public String toString() {
        return  str + " " + number;
    }
}
