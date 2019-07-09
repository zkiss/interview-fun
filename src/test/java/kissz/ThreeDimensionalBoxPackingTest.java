package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

import kissz.ThreeDimensionalBoxPacking.*;

import java.util.Arrays;

public class ThreeDimensionalBoxPackingTest {

    @Test
    public void oneBox_returnsBoxHeight() {
        assertEquals(3, ThreeDimensionalBoxPacking.pack(Arrays.asList(new Box(1, 1, 3))));
    }

    @Test
    public void twoBoxes_canbePacked() {
        Box a = new Box(1, 1, 3);
        Box b = new Box(2, 2, 5);
        assertEquals(8, ThreeDimensionalBoxPacking.pack(Arrays.asList(a, b)));
    }

    @Test
    public void threeBoxes_twoCanbePacked() {
        Box a = new Box(1, 1, 3);
        Box b = new Box(2, 2, 5);
        Box c = new Box(1, 2, 4);
        assertEquals(8, ThreeDimensionalBoxPacking.pack(Arrays.asList(a, b, c)));
    }

    @Test
    public void threeBoxes_twoCanbePacked_oneAloneIsTaller() {
        Box a = new Box(1, 1, 3);
        Box b = new Box(2, 2, 5);
        Box c = new Box(1, 2, 9);
        assertEquals(9, ThreeDimensionalBoxPacking.pack(Arrays.asList(a, b, c)));
    }

    @Test
    public void threeBoxes_threeCanbePacked() {
        Box a = new Box(1, 1, 3);
        Box b = new Box(2, 2, 5);
        Box c = new Box(4, 4, 9);
        assertEquals(17, ThreeDimensionalBoxPacking.pack(Arrays.asList(a, b, c)));
    }
}