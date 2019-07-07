package kissz;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RobotInAGrid {
    public static ArrayList<Dir> findRoute(
            HashSet<Coord> obstacles,
            int col,
            int row
    ) {
        ArrayList<Dir> ret = new ArrayList<Dir>(col - 1 + row - 1);

        Coord current = new Coord(0, 0);
        LinkedList<Coord> steps = new LinkedList<Coord>();
        final Coord end = new Coord(col - 1, row - 1);

        HashSet<Coord> fails = new HashSet<>();

        while (!current.equals(end) && !fails.contains(current)) {
            if (current.col < col - 1 && !obstacles.contains(current.right())) {
                steps.push(current);
                recordStep(current, Dir.RIGHT, ret);
                current = current.right();
            } else if (current.row < row - 1 && !obstacles.contains(current.down())) {
                steps.push(current);
                recordStep(current, Dir.DOWN, ret);
                current = current.down();
            } else {
                fails.add(current);
                current = steps.pop();
            }
        }

        if (!current.equals(end)) {
            return new ArrayList<>();
        }
        return ret;
    }

    private static void recordStep(Coord coord, Dir dir, ArrayList<Dir> ret) {
        ret.set(coord.col + coord.row, dir);
    }
}

class Coord {
    public final int col;
    public final int row;

    Coord(int col, int row) {
        this.col = col;
        this.row = row;
    }

    Coord right() {
        return new Coord(col + 1, row);
    }

    Coord down() {
        return new Coord(col, row + 1);
    }

    @Override
    public int hashCode() {
        return row << 10 + col;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coord) {
            Coord other = (Coord)o;
            return other.row == row && other.col == col;
        }
        return false;
    }

    // TODO eq, hashcode
}

enum Dir {
    DOWN, RIGHT
}