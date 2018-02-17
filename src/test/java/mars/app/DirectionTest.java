package mars.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void rotateClockWise() {
        assertEquals(Direction.E, Direction.N.rotateClockWise());
        assertEquals(Direction.N, Direction.W.rotateClockWise());
    }

    @Test
    public void rotateCounterClockWise() {
        assertEquals(Direction.S, Direction.W.rotateCounterClockWise());
        assertEquals(Direction.W, Direction.N.rotateCounterClockWise());
    }
}
