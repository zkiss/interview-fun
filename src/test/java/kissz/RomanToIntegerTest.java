package kissz;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RomanToIntegerTest {
    @Test
    public void testRomanToValue() {
        assertEquals(1998, new RomanToInteger().romanToInt("MCMXCVIII"));
        assertEquals(4, new RomanToInteger().romanToInt("IV"));
    }

    private RomanToInteger r = new RomanToInteger();

    @Test
    public void parsesZero() {
        RomanNumber number = new RomanNumber(RomanNumber.ZERO_VALUE);

        assertEquals(0, r.romanToInt(""));
    }

    @Test
    public void parsesSymbols() {
        Arrays.stream(RomanSymbol.values())
                .forEach(symbol -> {
                    assertEquals(symbol.getValue(), r.romanToInt(symbol.name()));
                });
    }

    @Test
    public void parsesTwo() {
        assertEquals(2, r.romanToInt("II"));
    }

    @Test
    public void parsesNine() {
        assertEquals(9, r.romanToInt("IX"));
    }

    @Test
    public void shouldParseGivenExamples() {
        assertEquals(1999, r.romanToInt("MCMXCIX"));
        assertEquals(2016, r.romanToInt("MMXVI"));
        assertEquals(944, r.romanToInt("CMXLIV"));
        assertEquals(470, r.romanToInt("CDLXX"));
        assertEquals(88, r.romanToInt("LXXXVIII"));
    }
}