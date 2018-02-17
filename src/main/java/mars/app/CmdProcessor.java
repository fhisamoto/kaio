package mars.app;

class InvalidCmdException extends Exception {
    public InvalidCmdException() {
        super();
    }
}

public class CmdProcessor {
    public static Position process(String cmd) throws OutOfBoundsException, InvalidCmdException {
        Position p = new Position(0, 0, Direction.N);
        for (char c : cmd.toCharArray()) {
            switch (Character.toUpperCase(c)) {
                case 'M':
                    p = p.step();
                    break;
                case 'R':
                    p = p.rotateClockWise();
                    break;
                case 'L':
                    p = p.rotateCounterClockWise();
                    break;
                default:
                    throw new InvalidCmdException();
            }
        }
        return p;
    }
}
