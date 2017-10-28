package antlen.rubiks;

/**
 * Created by antlen on 15/9/15.
 */

import antlen.rubiks.block.*;

import static antlen.rubiks.block.BlockFace.*;

public class Test {

    public static final Color RED = Color.RED;
    public static final Color WHITE = Color.WHITE;
    public static final Color YELLOW = Color.YELLOW;
    public static final Color GREEN = Color.GREEN;
    public static final Color ORANGE = Color.ORANGE;
    public static final Color BLUE = Color.BLUE;

    public static final BlockFace FRONT = front(WHITE);
    public static final BlockFace BACK = back(RED);
    public static final BlockFace TOP = top(YELLOW);
    public static final BlockFace BOTTOM = bottom(GREEN);
    public static final BlockFace LEFT = left(ORANGE);
    public static final BlockFace RIGHT = right(BLUE);


    public static final CornerBlock FRONT_LEFT_TOP = new CornerBlock(FRONT, LEFT, TOP);
    public static final CornerBlock FRONT_LEFT_BOTTOM = new CornerBlock(FRONT, LEFT, BOTTOM);
    public static final CornerBlock FRONT_RIGHT_TOP = new CornerBlock(FRONT, RIGHT, TOP);
    public static final CornerBlock FRONT_RIGHT_BOTTOM = new CornerBlock(FRONT, RIGHT, BOTTOM);

    public static final CornerBlock BACK_LEFT_TOP = new CornerBlock(BACK, LEFT, TOP);
    public static final CornerBlock BACK_LEFT_BOTTOM = new CornerBlock(BACK, LEFT, BOTTOM);
    public static final CornerBlock BACK_RIGHT_TOP = new CornerBlock(BACK, RIGHT, TOP);
    public static final CornerBlock BACK_RIGHT_BOTTOM = new CornerBlock(BACK, RIGHT, BOTTOM);

    public static final EdgeBlock FRONT_RIGHT = new EdgeBlock(FRONT, RIGHT);
    public static final EdgeBlock FRONT_LEFT = new EdgeBlock(FRONT, LEFT);
    public static final EdgeBlock FRONT_TOP = new EdgeBlock(FRONT, TOP);
    public static final EdgeBlock FRONT_BOTTOM = new EdgeBlock(FRONT, BOTTOM);

    public static final EdgeBlock LEFT_TOP = new EdgeBlock(LEFT, TOP);
    public static final EdgeBlock LEFT_BOTTOM = new EdgeBlock(LEFT, BOTTOM);
    public static final EdgeBlock LEFT_BACK = new EdgeBlock(LEFT, BACK);

    public static final EdgeBlock RIGHT_TOP = new EdgeBlock(RIGHT, TOP);
    public static final EdgeBlock RIGHT_BOTTOM = new EdgeBlock(RIGHT, BOTTOM);
    public static final EdgeBlock RIGHT_BACK = new EdgeBlock(RIGHT, BACK);

    public static final EdgeBlock BACK_TOP = new EdgeBlock(BACK, TOP);
    public static final EdgeBlock BACK_BOTTOM = new EdgeBlock(BACK, BOTTOM);

    public static final CenterBlock FRONT_CENTER = new CenterBlock(FRONT);
    public static final CenterBlock LEFT_CENTER = new CenterBlock(LEFT);
    public static final CenterBlock RIGHT_CENTER = new CenterBlock(RIGHT);
    public static final CenterBlock BACK_CENTER = new CenterBlock(BACK);
    public static final CenterBlock TOP_CENTER = new CenterBlock(TOP);
    public static final CenterBlock BOTTOM_CENTER = new CenterBlock(BOTTOM);

    public static void main(String arg[]){


        final Face front = new Face(Side.FRONT, new Block[][]{new Block[]{FRONT_LEFT_TOP, FRONT_TOP, FRONT_RIGHT_TOP},
                new Block[]{FRONT_LEFT, FRONT_CENTER, FRONT_RIGHT},
                new Block[]{FRONT_LEFT_BOTTOM, FRONT_BOTTOM, FRONT_RIGHT_BOTTOM}});

        final Face bottom = new Face(Side.BOTTOM, new Block[][]{new Block[]{FRONT_LEFT_BOTTOM, FRONT_BOTTOM, FRONT_RIGHT_BOTTOM},
                new Block[]{LEFT_BOTTOM, BOTTOM_CENTER, RIGHT_BOTTOM},
                new Block[]{BACK_LEFT_BOTTOM, BACK_BOTTOM, BACK_RIGHT_BOTTOM}});

        final Face back = new Face(Side.BACK, new Block[][]{new Block[]{BACK_LEFT_BOTTOM, BACK_BOTTOM, BACK_RIGHT_BOTTOM},
                new Block[]{LEFT_BACK, BACK_CENTER, RIGHT_BACK},
                new Block[]{BACK_LEFT_TOP, BACK_TOP, BACK_RIGHT_TOP}});

        final Face top = new Face(Side.TOP, new Block[][]{new Block[]{BACK_LEFT_TOP, BACK_TOP, BACK_RIGHT_TOP},
                new Block[]{LEFT_TOP, TOP_CENTER, RIGHT_TOP},
                new Block[]{FRONT_LEFT_TOP, FRONT_TOP, FRONT_RIGHT_TOP}});

        final Face left = new Face(Side.LEFT, new Block[][]{new Block[]{BACK_LEFT_TOP, LEFT_TOP, FRONT_LEFT_TOP},
                new Block[]{LEFT_BACK, LEFT_CENTER, FRONT_LEFT},
                new Block[]{BACK_LEFT_BOTTOM, LEFT_BOTTOM, FRONT_LEFT_BOTTOM}});

        final Face right = new Face(Side.RIGHT, new Block[][]{new Block[]{FRONT_RIGHT_TOP, RIGHT_TOP, BACK_RIGHT_TOP},
                new Block[]{FRONT_RIGHT, RIGHT_CENTER, RIGHT_BACK},
                new Block[]{FRONT_RIGHT_BOTTOM, RIGHT_BOTTOM, BACK_RIGHT_BOTTOM}});


        front.setEdges(top, left, right, bottom);
        back.setEdges(top, left, right, bottom);
        left.setEdges(front, bottom, back, top);
        right.setEdges(front, bottom, back, top);
        top.setEdges(front, back, left, right);
        bottom.setEdges(front, back, left, right);
        Cube cube = new Cube(front, bottom, back, top, left, right);

        front.rotate(1, Movement.HORIZONTAL_ANTI_CLOCKWISE);

        System.out.println(cube);

    }



    public static BlockFace front(Color c){
        return new BlockFace(c, Location.FRONT);
    }

    public static BlockFace back(Color c){
        return new BlockFace(c, Location.BACK);
    }

    public static BlockFace top(Color c){
        return new BlockFace(c, Location.TOP);
    }

    public static BlockFace bottom(Color c){
        return new BlockFace(c, Location.BOTTOM);
    }

    public static BlockFace left(Color c){
        return new BlockFace(c, Location.LEFT);
    }

    public static BlockFace right(Color c){
        return new BlockFace(c, Location.RIGHT);
    }
}
