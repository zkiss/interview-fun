package kissz;

import org.junit.Test;

import static kissz.MergeTwoSortedArrays.mergeTwo;
import static org.junit.Assert.*;

public class MergeTwoSortedArraysTest {

    @Test
    public void mergeTwo_first() {
        int[] a = {1, 3, 5, 7, 0, 0, 0};
        int[] b = {2, 4, 6};

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, mergeTwo(a, b, 4));
    }
}