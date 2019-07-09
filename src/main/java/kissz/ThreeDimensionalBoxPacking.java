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
    public static class Box {
        public final int x, y, z;

        public Box(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static int pack(List<Box> boxes) {
        List<Box> sortedByX =
                boxes.stream().sorted(Comparator.comparing(b -> b.x)).collect(Collectors.toList());

        final int n = boxes.size();
        int[] resultVectorPrev = sortedByX.stream().mapToInt(b -> b.z).toArray();
        int[] resultVectorCurr = new int[n];
        // Use for swaps;
        int[] temp;

        int maxHeight = Arrays.stream(resultVectorPrev).max().getAsInt();
        boolean changed = true;
        // The last element's calculated value is final after each iteration. Reduce iteration length.
        for (int i = n; changed; i--){
            changed = false;
            for (int j = 0; j < i; j++) {
                resultVectorCurr[j] = resultVectorPrev[j];
                Box candidate = sortedByX.get(j);
                for (int k = j + 1; k < n; k++) {
                    if (sortedByX.get(k).y > candidate.y && sortedByX.get(k).x > candidate.x && resultVectorPrev[k] + candidate.z > resultVectorPrev[j]) {
                        resultVectorCurr[j] = resultVectorPrev[k] + candidate.z;
                        changed = true;
                        if (maxHeight < resultVectorCurr[j]) maxHeight = resultVectorCurr[j];
                    }
                }
            }
            temp = resultVectorPrev;
            resultVectorPrev = resultVectorCurr;
            resultVectorCurr = temp;
        }

        return maxHeight;
    }
}
