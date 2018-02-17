package mars.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void formatsPosition() {
        assertEquals("(0,0,N)", (new Position(0,0, Direction.N)).toString());
    }

    @Test
    public void stepsNorth() throws OutOfBoundsException{
        assertEquals("(0,1,N)", (new Position(0,0, Direction.N).step().toString()));
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsToStepNorth() throws OutOfBoundsException {
        (new Position(0,5, Direction.N)).step();
    }

    @Test
    public void stepsEast() throws OutOfBoundsException{
        assertEquals("(2,0,E)", (new Position(1,0, Direction.E).step().toString()));
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsToStepEast() throws OutOfBoundsException {
        (new Position(5,0, Direction.E)).step();
    }

    @Test
    public void stepsSouth() throws OutOfBoundsException{
        assertEquals("(2,1,S)", (new Position(2,2, Direction.S).step().toString()));
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsToStepSouth() throws OutOfBoundsException {
        (new Position(2,0, Direction.S)).step();
    }

    @Test
    public void stepsWest() throws OutOfBoundsException{
        assertEquals("(2,1,W)", (new Position(3,1, Direction.W).step().toString()));
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsToStepWest() throws OutOfBoundsException {
        (new Position(0,1, Direction.W)).step();
    }
}
