package io.ailo;

import io.ailo.models.Zombie;
import io.ailo.models.ZombieQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZombieQueueTest {

    ZombieQueue queue;

    @Before
    public void setUp() {
        queue = new ZombieQueue();
    }

    @Test
    public void testEmptyQueue() {
        assertFalse(queue.hasNext());
    }

    @Test
    public void testNonEmptyQueue() {
        queue.add(new Zombie(1,2));
        assertTrue(queue.hasNext());
    }

    @Test
    public void testPopsFirstZombie() {
        Zombie zombie1 = new Zombie(1,2);
        Zombie zombie2 = new Zombie(3,6);
        Zombie zombie3 = new Zombie(0,0);
        queue.add(zombie3);
        queue.add(zombie1);
        queue.add(zombie2);
        assertEquals(queue.next(), zombie3);
    }

}
