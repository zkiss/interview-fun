package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateMatrixTest {

    @Test
    public void testOdd() {
        int[][] mx = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };

        RotateMatrix.rotate90(mx);

        assertArrayEquals(
                new int[][]{
                        new int[]{3, 6, 9},
                        new int[]{2, 5, 8},
                        new int[]{1, 4, 7},
                },
                mx
        );
    }

    @Test
    public void testEvenSmall() {
        int[][] mx = {
                new int[]{1, 2},
                new int[]{3, 4}
        };

        RotateMatrix.rotate90(mx);

        assertArrayEquals(
                new int[][]{
                        new int[]{2, 4},
                        new int[]{1, 3},
                },
                mx
        );
    }

    @Test
    public void testEvenLarge() {
        int[][] mx = {
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16},
        };

        RotateMatrix.rotate90(mx);

        assertArrayEquals(
                new int[][]{
                        new int[]{4, 8, 12, 16},
                        new int[]{3, 7, 11, 15},
                        new int[]{2, 6, 10, 14},
                        new int[]{1, 5, 9, 13},
                },
                mx
        );
    }

}