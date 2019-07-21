package kissz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class ThreeSumTest {

    private ThreeSum ts = new ThreeSum();

    @Test
    public void example() {
        var r = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, r.size());
        Assert.assertTrue(r.stream().anyMatch(l -> l.size() == 3 && l.containsAll(Arrays.asList(-1, 0, 1))));
        Assert.assertTrue(r.stream().anyMatch(l -> l.size() == 3 && new HashSet<>(l).equals(new HashSet<>(Arrays.asList(-1, -1, 2)))));
    }

}