package mars.app;

class OutOfBoundsException extends Exception {
    public OutOfBoundsException() {
        super();
    }
}

public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position step() throws OutOfBoundsException{
        int x1 = x, y1 = y;
        switch (direction) {
            case N:
                y1 = y + 1;
                break;
            case E:
                x1 = x + 1;
                break;
            case S:
                y1 = y - 1;
                break;
            case W:
                x1 = x - 1;
                break;
        }
        if ((x1 < 0) || (x1 > 5) || (y1 < 0) || (y1 > 5)) {
            throw new OutOfBoundsException();
        }
        return new Position(x1, y1, direction);
    }

    public Position rotateClockWise() {
        return new Position(x, y, direction.rotateClockWise());
    }

    public Position rotateCounterClockWise() {
        return new Position(x, y, direction.rotateCounterClockWise());
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%s)", x, y, direction.toString());
    }
}
