package antlen.rubiks.block;

import antlen.rubiks.Location;

/**
 * Created by antlen on 15/9/15.
 */
public class BlockFace {
    public enum Color{

        RED, YELLOW, GREEN, BLUE, ORANGE, WHITE;

        private final String colorId;

        Color(){
            colorId=name().substring(0,1);
        }

        public String getColorId(){
            return colorId;
        }

    }

    private Color color;
    private final Location location;

    public BlockFace(Color color, Location location) {
        this.color = color;
        this.location = location;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return color.getColorId();
    }
}
