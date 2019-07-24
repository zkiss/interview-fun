package kissz;

import org.junit.Test;

import static kissz.DivisorGame.divisorsDecreasing;
import static org.junit.Assert.*;

public class DivisorGameTest {

    private DivisorGame game = new DivisorGame();

    @Test
    public void examples() {
        assertTrue(game.divisorGame(2));
        assertFalse(game.divisorGame(3));
    }

    @Test
    public void test() {
        assertFalse(game.divisorGame(1));
        assertTrue(game.divisorGame(2));
        assertFalse(game.divisorGame(3));
        assertTrue(game.divisorGame(4));
        assertFalse(game.divisorGame(5));
        assertTrue(game.divisorGame(6));
        assertFalse(game.divisorGame(7));
        assertTrue(game.divisorGame(8));
    }

    @Test
    public void iterator() {
//        var i = divisorsDecreasing(1);
//        assertFalse(i.hasNext());
//
//        i = divisorsDecreasing(2);
//        assertEquals(1, (int) i.next());
//        assertFalse(i.hasNext());
//
//        i = divisorsDecreasing(3);
//        assertEquals(1, (int) i.next());
//        assertFalse(i.hasNext());
//
//        i = divisorsDecreasing(4);
//        assertEquals(2, (int) i.next());
//        assertEquals(1, (int) i.next());
//        assertFalse(i.hasNext());
    }

}