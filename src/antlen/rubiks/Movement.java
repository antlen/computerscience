package antlen.rubiks;

/**
 * Created by antlen on 19/9/15.
 */
public enum Movement {
    HORIZONTAL_CLOCKWISE(Aspect.HORIZONTAL, Direction.CLOCKWISE),
    HORIZONTAL_ANTI_CLOCKWISE(Aspect.HORIZONTAL, Direction.ANTI_CLOCKWISE),
    VIRTICAL_CLOCKWISE(Aspect.VERTICAL, Direction.CLOCKWISE),
    VIRTICAL_ANTI_CLOCKWISE(Aspect.VERTICAL, Direction.ANTI_CLOCKWISE);



    private Aspect aspect;
    private Direction direction;

    Movement(Aspect aspect, Direction d) {
        this.aspect = aspect;
        this.direction=d;
    }

    public Aspect getAspect() {
        return aspect;
    }

    public Direction getDirection() {
        return direction;
    }
}
