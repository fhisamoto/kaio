package mars.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CmdProcessorTest {

    @Test
    public void successfullWalkRightTest() throws Exception {
        assertEquals(new Position(2, 0, Direction.S), CmdProcessor.process("MMRMMRMM"));
    }

    @Test
    public void successfullWalkLeftTest() throws Exception {
        assertEquals(new Position(0, 2, Direction.W), CmdProcessor.process("MML"));
    }

    @Test(expected = InvalidCmdException.class)
    public void failsWithInvalidCmdException() throws Exception {
        CmdProcessor.process("AAA");
    }

    @Test(expected = OutOfBoundsException.class)
    public void failsWithOutOfBoundsException() throws Exception {
        CmdProcessor.process("MMMMMMMMMMMMMMMMMMMMMMMM");
    }
}
