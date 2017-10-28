package antlen.rubiks;

import antlen.collections.Collection;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by antlen on 15/9/15.
 */
public enum Side {
    TOP(Location.TOP, Corner.TOP, new Connection(Location.FRONT, Movement.VIRTICAL_CLOCKWISE), new Connection(Location.BACK, Movement.VIRTICAL_ANTI_CLOCKWISE),
            new Connection(Location.LEFT, Movement.HORIZONTAL_CLOCKWISE), new Connection(Location.RIGHT, Movement.HORIZONTAL_ANTI_CLOCKWISE)),
    BOTTOM(Location.BOTTOM, Corner.BOTTOM, new Connection(Location.FRONT, Movement.VIRTICAL_ANTI_CLOCKWISE), new Connection(Location.BACK, Movement.VIRTICAL_CLOCKWISE),
            new Connection(Location.LEFT, Movement.HORIZONTAL_ANTI_CLOCKWISE), new Connection(Location.RIGHT, Movement.HORIZONTAL_CLOCKWISE)),
    FRONT(Location.FRONT, Corner.FRONT, new Connection(Location.TOP, Movement.VIRTICAL_ANTI_CLOCKWISE), new Connection(Location.BOTTOM, Movement.VIRTICAL_CLOCKWISE),
            new Connection(Location.LEFT, Movement.HORIZONTAL_CLOCKWISE), new Connection(Location.RIGHT, Movement.HORIZONTAL_ANTI_CLOCKWISE)),
    BACK(Location.BACK, Corner.BACK, new Connection(Location.TOP, Movement.VIRTICAL_CLOCKWISE), new Connection(Location.BOTTOM, Movement.VIRTICAL_ANTI_CLOCKWISE),
            new Connection(Location.LEFT, Movement.HORIZONTAL_ANTI_CLOCKWISE), new Connection(Location.RIGHT, Movement.HORIZONTAL_CLOCKWISE)),
    RIGHT(Location.RIGHT, Corner.RIGHT, new Connection(Location.TOP, Movement.VIRTICAL_ANTI_CLOCKWISE), new Connection(Location.BOTTOM, Movement.VIRTICAL_CLOCKWISE),
            new Connection(Location.FRONT, Movement.HORIZONTAL_CLOCKWISE), new Connection(Location.BACK, Movement.HORIZONTAL_ANTI_CLOCKWISE)),
    LEFT(Location.LEFT, Corner.LEFT, new Connection(Location.TOP, Movement.VIRTICAL_CLOCKWISE), new Connection(Location.BOTTOM, Movement.VIRTICAL_ANTI_CLOCKWISE),
            new Connection(Location.FRONT, Movement.HORIZONTAL_ANTI_CLOCKWISE), new Connection(Location.BACK, Movement.HORIZONTAL_CLOCKWISE));


    static{
        Map<Location, Side> m = new EnumMap<Location, Side>(Location.class);
        for(Side s : Side.values()){
            m.put(s.getLocation(), s);
        }
        sides = Collections.unmodifiableMap(m);
    }

    private static final Map<Location, Side> sides;

    public static Side getSide(Location l){
        return sides.get(l);
    }

    private final Connection[] edges;
    private final Location location;
    private final Corner[] corners;
    private final Map<Location, Movement> movements = new EnumMap<Location, Movement>(Location.class);

    Side(Location location, Corner[] corners, Connection ... edges) {
        this.edges = edges;
        this.corners=corners;
        this.location=location;
        for(Connection c : edges){
            movements.put(c.getLocation(), c.getMovement());
        }
    }

    public Location getLocation() {
        return location;
    }


    public Movement getMovement(Location l) {
        return movements.get(l);
    }

    public Corner[] getCorners() {
        return corners;
    }
}

