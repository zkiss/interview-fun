package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnightRemainsOnTheBoardTest {

    @Test
    public void example1() {
        assertEquals(0.0625d, new KnightRemainsOnTheBoard().knightProbability(
                3, 2, 0, 0
        ), 0.0001);
    }
}