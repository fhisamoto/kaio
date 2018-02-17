package mars.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void formatsPosition() {
        assertEquals("(0,0,N)", (new Position(0, 0, Direction.N)).toString());
    }

    @Test
    public void stepsNorth() throws Exception {
        assertEquals(new Position(0, 1, Direction.N), new Position(0, 0, Direction.N).step());
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsToStepNorth() throws Exception {
        (new Position(0, 5, Direction.N)).step();
    }

    @Test
    public void stepsEast() throws Exception {
        assertEquals(new Position(2, 0, Direction.E), new Position(1, 0, Direction.E).step());
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsToStepEast() throws Exception {
        (new Position(5, 0, Direction.E)).step();
    }

    @Test
    public void stepsSouth() throws Exception {
        assertEquals(new Position(2, 1, Direction.S), new Position(2, 2, Direction.S).step());
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsToStepSouth() throws Exception {
        (new Position(2, 0, Direction.S)).step();
    }

    @Test
    public void stepsWest() throws Exception {
        assertEquals(new Position(2, 1, Direction.W), new Position(3, 1, Direction.W).step());
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsToStepWest() throws Exception {
        (new Position(0, 1, Direction.W)).step();
    }
}
