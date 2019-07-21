package kissz;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class LetterCombinationsOfAPhoneNumberTest {

    private LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();

    @Test
    public void example() {
        assertEquals(
                new HashSet<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                new HashSet<>(lc.letterCombinations("23"))
        );
    }

}