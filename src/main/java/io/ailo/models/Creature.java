package io.ailo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Creature implements CreatureSubject, ZombieMoveObserver {
    private int x;
    private int y;
    private List<CreatureObserver> observers;


    public Creature(int x, int y){
        this.x = x;
        this.y = y;
        this.observers = new ArrayList<>();
    }

    public boolean dead(int x, int y){
        if(this.x == x && this.y == y) {
            return true;
        }
        return false;
    }

    public static String[] request_positions(Scanner in) {
        System.out.print("Please enter list of creature positions: ");
        String creature_positions = in.next("(\\(\\d,\\d\\))+");
        String[] coordinate_pairs = creature_positions.replace(")(", " ")
                .replace("(", "")
                .replace(")", "").split(" ");
        return coordinate_pairs;
    }

    public static List<ZombieMoveObserver> hide(String[] coordinate_pairs) {
        List<ZombieMoveObserver> creatures = new ArrayList<ZombieMoveObserver>();

        for(String pair : coordinate_pairs) {
            String [] coordinates = pair.split(",");
            creatures.add(new Creature(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
        }
        return creatures;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public void update_position(int x, int y) {
        if(dead(x, y)) notifyObservers();
    }

    @Override
    public void registerObserver(CreatureObserver o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(CreatureObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return x == creature.x &&
                y == creature.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
