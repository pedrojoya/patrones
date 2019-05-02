package es.iessaladillo.pedrojoya.patrones.DatabaseEagerSingleton.data.entity;

import java.util.Objects;

public class Student {

    private static final int MAX_AGE = 150;

    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        checkInvariant();
    }

    private void checkInvariant() {
        Objects.requireNonNull(name);
        if (age < 0 || age > MAX_AGE) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    @Override
    public String toString() {
        return String.format("{%s, %d}", name, age);
    }

}
