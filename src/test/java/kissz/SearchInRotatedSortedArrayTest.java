package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

    @Test
    public void examples() {
        assertEquals(4, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, s.search(new int[]{2}, 3));
        assertEquals(0, s.search(new int[]{3}, 3));
        assertEquals(1, s.search(new int[]{1, 0}, 0));
        assertEquals(0, s.search(new int[]{1, 3, 5}, 1));
    }

}