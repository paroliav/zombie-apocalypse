package io.ailo;

import io.ailo.models.Grid;
import io.ailo.models.Zombie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZombieTest {
    Zombie zombie;
    Grid grid;

    @Before
    public void setUp() {
        zombie = new Zombie(2,4);
        grid = new Grid(5);
    }

    @Test
    public void testWalkUp(){
        Zombie.walking_instructions("U");
        zombie.walk(grid);
        assertEquals(zombie.getY(), 3);
    }

    @Test
    public void testWalkDown(){
        Zombie.walking_instructions("D");
        zombie.walk(grid);
        assertEquals(zombie.getY(), 0);
    }

    @Test
    public void testWalkLeft(){
        Zombie.walking_instructions("L");
        zombie.walk(grid);
        assertEquals(zombie.getX(), 1);
    }

    @Test
    public void testWalkRight(){
        Zombie.walking_instructions("R");
        zombie.walk(grid);
        assertEquals(zombie.getX(), 3);
    }

    @Test
    public void testWalkASeriesOfMoves(){
        Zombie.walking_instructions("RRDL");
        zombie.walk(grid);
        assertEquals(zombie.getX(), 3);
        assertEquals(zombie.getY(), 0);
    }
}
