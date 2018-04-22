package antlen.rubiks.block;

import antlen.rubiks.Location;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by antlen on 15/9/15.
 */
public class Block {


    private final Map<Location, BlockFace> faces;

    public Block(BlockFace ... faces){
        final Map<Location, BlockFace> m = new HashMap<>();
        for(BlockFace f : faces){
            m.put(f.getLocation(), f);
        }
        this.faces = Collections.unmodifiableMap(m);
    }

    public BlockFace getFace(Location l){
        return faces.get(l);
    }
}
