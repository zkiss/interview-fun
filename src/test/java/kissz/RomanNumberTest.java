package kissz;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RomanNumberTest {

    @Test
    public void parsesZero() {
        RomanNumber number = new RomanNumber(RomanNumber.ZERO_VALUE);

        assertEquals(0, number.value());
    }

    @Test
    public void parsesSymbols() {
        Arrays.stream(RomanSymbol.values())
                .forEach(symbol -> {
                    RomanNumber number = new RomanNumber(symbol.name());
                    assertEquals(symbol.getValue(), number.value());
                });
    }

    @Test
    public void parsesTwo() {
        RomanNumber number = new RomanNumber("II");

        assertEquals(2, number.value());
    }

    @Test
    public void parsesNine() {
        RomanNumber number = new RomanNumber("IX");

        assertEquals(number.value(), 9);
    }

    @Test
    public void comparesByMagnitude() {
        assertTrue(RomanSymbol.I.isSmallerMagnitudeThan(RomanSymbol.X));
    }

    @Test
    public void shouldParseGivenExamples() {
        assertEquals(1999, new RomanNumber("MCMXCIX").value());
        assertEquals(2016, new RomanNumber("MMXVI").value());
        assertEquals(944, new RomanNumber("CMXLIV").value());
        assertEquals(470, new RomanNumber("CDLXX").value());
        assertEquals(88, new RomanNumber("LXXXVIII").value());
    }
}