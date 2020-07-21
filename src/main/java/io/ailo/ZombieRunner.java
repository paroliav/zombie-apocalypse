package io.ailo;

import io.ailo.models.Creature;
import io.ailo.models.Grid;
import io.ailo.models.Zombie;
import io.ailo.models.ZombieMoveObserver;

import java.util.List;
import java.util.Scanner;

public class ZombieRunner {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Grid grid = new Grid(Grid.requestSize(in));
        Zombie zombie = Zombie.wake(Zombie.request_position(in));
        List<ZombieMoveObserver> creatures = Creature.hide(Creature.request_positions(in));

        grid.setup(zombie, creatures);
        Zombie.walking_instructions(Zombie.request_moves(in));

        grid.start_attack();

        List<Zombie> end_of_apocalypse_zombies = grid.getZombies();
        System.out.println(String.format("zombies score: %d", end_of_apocalypse_zombies.size() - 1));
        System.out.println("zombies positions:");
        for(Zombie end_of_apocalypse_zombie : end_of_apocalypse_zombies) {
            System.out.print(end_of_apocalypse_zombie.position());
        }

    }
}
