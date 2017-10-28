package antlen.rubiks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by antlen on 15/9/15.
 */
public class Cube {

    private final Map<Side, Face>  faces;

    public Cube(Face ... faces){
        if(faces.length != 6){
            throw new IllegalArgumentException("A cube needs 6 sides");
        }
        Map<Side, Face> m = new HashMap<>();
        for(Face f : faces){
            m.put(f.getSide(), f);
        }
        this.faces= Collections.unmodifiableMap(m);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for(Face f : faces.values()){
           b.append(f);
        }

        return b.toString();
    }
}
