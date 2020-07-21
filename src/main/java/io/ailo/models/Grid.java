package io.ailo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grid implements CreatureObserver {
    private int size;
    private List<Zombie> zombies;
    private List<ZombieMoveObserver> creatures;
    private ZombieQueue queue;

    public Grid(int size) {
        this.size = size;
        zombies = new ArrayList<>();
        creatures = new ArrayList<>();
        queue = new ZombieQueue();
    }

    public static int requestSize(Scanner in){
        System.out.print("Please enter grid size: ");
        return in.nextInt();
    }

    public void setup(Zombie zombie, List<ZombieMoveObserver> creatures){
        queue.add(zombie);
        this.creatures.addAll(creatures);

        for(ZombieMoveObserver creature : creatures){
            ((Creature)creature).registerObserver(this);
        }
    }

    public void start_attack(){
        if(queue.hasNext()){
            Zombie zombie = queue.next();
            zombie.registerMoveObserver(creatures);
            zombie.registerWalkObserver(queue);
            zombies.add(zombie);
            zombie.walk(this);
        }
    }


    public int forward(int coordinate) {
        return coordinate + 1 == size ? 0 : coordinate +1;
    }

    public int backward(int coordinate) {
        return coordinate - 1 == -1 ? size -1 : coordinate - 1;
    }

    public List<Zombie> getZombies(){
        return zombies;
    }

    @Override
    public void update(Creature creature) {
        creatures.remove(creature);
        Zombie zombie = new Zombie(creature.getX(), creature.getY());
        queue.add(zombie);
    }

}
