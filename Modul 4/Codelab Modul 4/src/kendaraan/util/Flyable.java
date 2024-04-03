package kendaraan.util;

public interface Flyable {
    default void fly() {
        System.out.println("Flying...");
    }
}
