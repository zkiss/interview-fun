package kissz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeDimensionalBoxPacking {
    public class Box {
        public final int x, y, z;

        public Box(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }

    public int pack(List<Box> boxes) {
        List<Box> sortedByX =
                boxes.stream().sorted(Comparator.comparing(Box::getX)).collect(Collectors.toList());
        List<Box> sortedByY =
                boxes.stream().sorted(Comparator.comparing(Box::getY)).collect(Collectors.toList());

        int[] resultVector = new int[boxes.size()];

        int i = 0;
        int height = 0;
        Deque<Box> tower = new LinkedList<>();
        Box box = sortedByX.get(i);
        height += box.getZ();
        //tower.push(i);
        int j = sortedByY.indexOf(box);
        if (resultVector[i] > 0) {
            int result = resultVector[i] + height;
            resultVector[i] = result;
        } else {
            for (int k = i + 1; k < sortedByX.size() - 1; k++) {

            }
        }

        return Arrays.stream(resultVector).max().getAsInt();
    }
}
