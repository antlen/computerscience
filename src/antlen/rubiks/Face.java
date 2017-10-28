package antlen.rubiks;

import antlen.rubiks.block.Block;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by antlen on 15/9/15.
 */
public class Face {

    private final Block[][] blocks;
    private final Side side;
    private Map<Movement, Face> directions;

    public Face(Side s, Block[][] blocks) {
        this.blocks = blocks;
        this.side=s;
    }

    public Side getSide() {
        return side;
    }

    public void setEdges(Face ... edges){
        //Map<Location, Face> m = new HashMap<>();
        Map<Movement, Face> d = new HashMap<>();
        for(Face f : edges){
         //   m.put(f.side.getLocation(), f);
            d.put(side.getMovement(f.getSide().getLocation()), f);
        }
       // this.edges = Collections.unmodifiableMap(m);
        this.directions = Collections.unmodifiableMap(d);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("\t").append(side.getLocation()).append("\n");
        for(int row = 0; row < blocks.length; row++){
            b.append("-------------\n");
            for(int col = 0; col < blocks[row].length; col++){
                b.append("| ").append(blocks[row][col].getFace(side.getLocation())).append(" ");
            }
            b.append("|\n");
        }
        b.append("-------------\n");
        return b.toString();
    }

    public void rotate(int index, Movement movement){
        rotateUntil(this, index, blocks[index], movement, true);
    }

    protected void rotateUntil(Face start, int index, Block[] vals, Movement movement, boolean initial){
        Block[] oldVals = blocks[index];
        if(!initial){
            for(int i = 0; i < oldVals.length; i++){
                //soldVals[i].
            }
          blocks[index]=vals;

        }
        if(initial || start != this){
            Face f = directions.get(movement);
            f.rotateUntil(start,index, oldVals, movement, false);
        }
    }
}
