package kissz;

import org.junit.Test;

import static kissz.LongestOneSeq.lengthOfLongestPossibleOneSeqAfterOneBitSet;
import static org.junit.Assert.*;

public class LongestOneSeqTest {

    @Test
    public void minInt_32() {
        assertEquals(32, lengthOfLongestPossibleOneSeqAfterOneBitSet(Integer.MIN_VALUE));
    }

    @Test
    public void zero_1() {
        assertEquals(1, lengthOfLongestPossibleOneSeqAfterOneBitSet(0));
    }

    @Test
    public void zoliAggodalmas_1() {
        assertEquals(4, lengthOfLongestPossibleOneSeqAfterOneBitSet(0b0000110001110));
    }

    @Test
    public void negativeTest() {
        assertEquals(7, lengthOfLongestPossibleOneSeqAfterOneBitSet(0b10111110001110000000111100000000));
    }
}