package antlen.rubiks;

/**
 * Created by antlen on 15/9/15.
 */
public enum Corner {
    FRONT_LEFT_TOP(Location.FRONT, Location.LEFT, Location.TOP),
    FRONT_LEFT_BOTTOM(Location.FRONT, Location.LEFT, Location.BOTTOM),
    FRONT_RIGHT_TOP(Location.FRONT, Location.RIGHT, Location.TOP),
    FRONT_RIGHT_BOTTOM(Location.FRONT, Location.RIGHT, Location.BOTTOM),
    BACK_LEFT_TOP(Location.BACK, Location.LEFT, Location.TOP),
    BACK_LEFT_BOTTOM(Location.BACK, Location.LEFT, Location.BOTTOM),
    BACK_RIGHT_TOP(Location.BACK, Location.RIGHT, Location.TOP),
    BACK_RIGHT_BOTTOM(Location.BACK, Location.RIGHT, Location.BOTTOM);


    public static final Corner[] FRONT = {FRONT_LEFT_TOP, FRONT_RIGHT_TOP, FRONT_LEFT_BOTTOM, FRONT_RIGHT_BOTTOM};
    public static final Corner[] BACK = {BACK_LEFT_TOP, BACK_LEFT_BOTTOM, BACK_RIGHT_TOP,BACK_RIGHT_BOTTOM};
    public static final Corner[] LEFT = {BACK_LEFT_TOP, BACK_LEFT_BOTTOM, FRONT_LEFT_TOP, FRONT_LEFT_BOTTOM};
    public static final Corner[] RIGHT = {FRONT_RIGHT_TOP, FRONT_RIGHT_BOTTOM, BACK_RIGHT_TOP, BACK_RIGHT_BOTTOM};
    public static final Corner[] BOTTOM = {FRONT_LEFT_BOTTOM, FRONT_RIGHT_BOTTOM, BACK_LEFT_BOTTOM, BACK_RIGHT_BOTTOM};
    public static final Corner[] TOP = {FRONT_LEFT_TOP, FRONT_RIGHT_TOP, BACK_LEFT_TOP, BACK_RIGHT_TOP};

    private final Location[] edges;

    Corner(Location ... edges) {
        this.edges = edges;
    }


}
