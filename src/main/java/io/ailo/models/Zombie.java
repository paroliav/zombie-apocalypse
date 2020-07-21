package io.ailo.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Zombie implements ZombieSubject{
    private int x;
    private int y;
    private static char[] moves;
    private List<ZombieMoveObserver> moveObservers;
    private List<ZombieWalkObserver> walkObservers;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
        moveObservers = new ArrayList<>();
        walkObservers = new ArrayList<>();
    }

    public void walk(Grid grid){
        for(char move : moves){
            move(move, grid);
        }
        notifyWalkObservers(grid);
    }

    private void move(char move, Grid grid) {
        switch (move) {
            case 'U':
                y = grid.backward(y);
                break;
            case 'D':
                y = grid.forward(y);
                break;
            case 'L':
                x = grid.backward(x);
                break;
            case 'R':
                x = grid.forward(x);
                break;
        }
        notifyMoveObservers();
    }

    public static String[] request_position(Scanner in) {
        System.out.print("Please enter initial zombie position: ");
        String zombie_position = in.next("\\(\\d,\\d\\)");
        String[] zombie_coordinates = zombie_position
                .replace("(", "")
                .replace(")", "").split(",");
        String[] coordinates = {zombie_coordinates[0], zombie_coordinates[1]};
        return coordinates;
    }

    public static Zombie wake(String[] coordinates){
        return new Zombie(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

    public static String request_moves(Scanner in){
        System.out.print("Please enter Zombie movements: ");
        return in.next("([A-Z])+");
    }

    public static void walking_instructions(String instructions) {
        moves = instructions.toCharArray();
    }

    public static char[] getMoves() {
        return moves;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String position() {
        return String.format("(%d,%d)", x, y);
    }

    @Override
    public void registerMoveObserver(List<ZombieMoveObserver> o) {
        moveObservers.addAll(o);
    }

    @Override
    public void registerWalkObserver(ZombieWalkObserver o) {
        walkObservers.add(o);
    }

    @Override
    public void notifyMoveObservers() {
        for(ZombieMoveObserver observer: moveObservers){
            observer.update_position(x, y);
        }
    }

    @Override
    public void notifyWalkObservers(Grid grid) {
        for(ZombieWalkObserver observer: walkObservers){
            observer.update_end_of_walk(grid);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zombie zombie = (Zombie) o;
        return x == zombie.x &&
                y == zombie.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
