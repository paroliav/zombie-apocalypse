package io.ailo.models;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieQueue implements ZombieWalkObserver {
    private Queue<Zombie> zombies;

    public ZombieQueue(){
        zombies = new LinkedList<>();
    }

    public void add(Zombie zombie) {
        zombies.add(zombie);
    }

    public boolean hasNext() {
        return zombies.isEmpty() ? false : true;
    }

    public Zombie next() {
        return zombies.remove();
    }

    @Override
    public void update_end_of_walk(Grid grid) {
        grid.start_attack();
    }
}
