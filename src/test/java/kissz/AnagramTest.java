package kissz;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    Anagram classUnderTest = new Anagram();

    @Test
    public void anagram() {
        assertTrue(classUnderTest.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void notAnagram() {
        assertFalse(classUnderTest.isAnagram("car", "rat"));
    }
}