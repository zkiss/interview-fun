package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();

    @Test
    public void example1() {
        int[] a = new int[]{1, 1, 2};
        assertEquals(2, r.removeDuplicates(a));
        assertArrayEquals(new int[]{1, 2, 2}, a);
    }

    @Test
    public void example2() {
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertEquals(5, r.removeDuplicates(a));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3, 4}, a);
    }

}