package antlen.rubiks;

/**
 * Created by antlen on 15/9/15.
 */
public class Connection {

    private final Location location;
    private final Movement movement;

    public Connection(Location location, Movement m) {
        this.location = location;
        this.movement = m;
    }

    public Location getLocation() {
        return location;
    }

    public Movement getMovement() {
        return movement;
    }
}
