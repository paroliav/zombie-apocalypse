package io.ailo;

import io.ailo.models.Creature;
import io.ailo.models.Grid;
import io.ailo.models.Zombie;
import io.ailo.models.ZombieMoveObserver;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ZombieRunnerTest {
    Grid grid;
    Zombie zombie;
    List<ZombieMoveObserver> creatures;

    @Before
    public void setUp() {
        grid = new Grid(4);
        zombie = new Zombie(2,1);
        creatures = new ArrayList<io.ailo.models.ZombieMoveObserver>(){{
            add(new Creature(0,1));
            add(new Creature(1,2));
            add(new Creature(3, 1));
        }};
        grid.setup(zombie, creatures);
        Zombie.walking_instructions("DLUURR");
    }

    @Test
    public void zombieMakesZombie() {
        grid.start_attack();

        assertEquals(3, grid.getZombies().size() -1);
    }

    @Test
    public void zombiePositions() {
        grid.start_attack();

        StringBuffer positions = new StringBuffer();
        for(Zombie zombie: grid.getZombies()){
            positions.append(zombie.position());
        }

        assertEquals("(3,0)(2,1)(1,0)(0,0)", positions.toString());
    }
}
