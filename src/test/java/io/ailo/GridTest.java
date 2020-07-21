package io.ailo;

import io.ailo.models.Grid;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTest {
    int size = 5;
    Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(size);
    }

    @Test
    public void testForwardIsOutsideTheGrid(){
        assertEquals(grid.forward(4), 0);
    }

    @Test
    public void testForwardIsInsideTheGrid(){
        assertEquals(grid.forward(2), 3);
    }

    @Test
    public void testBackwardIsOutsideTheGrid() {
        assertEquals(grid.backward(0), 4);
    }

    @Test
    public void testBackwardIsInsideTheGrid() {
        assertEquals(grid.backward(2), 1);
    }

}
