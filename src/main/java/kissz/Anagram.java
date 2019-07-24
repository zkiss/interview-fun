package kissz;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Integer, Long> codePointCountOne = s.codePoints().boxed().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        Map<Integer, Long> codePointCountTwo = t.codePoints().boxed().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));

        return codePointCountOne.equals(codePointCountTwo);
    }
}
