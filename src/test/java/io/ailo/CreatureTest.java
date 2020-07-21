package io.ailo;

import io.ailo.models.Creature;
import io.ailo.models.ZombieMoveObserver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreatureTest {
    Creature creature;

    @Test
    public void testZombieMovesToSameCellAsCreature(){
        creature = new Creature(2,3);
        assertTrue(creature.dead(2,3));
    }

    @Test
    public void testZombieMovesToADifferentCell(){
        creature = new Creature(2,3);
        assertFalse(creature.dead(3,3));
    }

    @Test
    public void testCreatesCreatures(){
        List<ZombieMoveObserver> actualCreatures = Creature.hide(new String[]{"3,2", "4,2", "2,1"});
        List<ZombieMoveObserver> expectedCreatures = new ArrayList<ZombieMoveObserver>(){{
            add(new Creature(3,2));
            add(new Creature(4,2));
            add(new Creature(2,1));
        }};
        assertTrue(expectedCreatures.containsAll(actualCreatures));
    }
}
