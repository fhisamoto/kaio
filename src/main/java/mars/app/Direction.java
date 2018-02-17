package mars.app;

public enum Direction {
    N, E, S, W;

    public Direction rotateClockWise() {
        return values()[(ordinal() + 1) % values().length];
    }

    public Direction rotateCounterClockWise() {
        int o = ordinal() - 1;
        return values()[(o < 0) ? values().length - 1 : o];
    }
}
