package kissz;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ret = Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        s -> s.codePoints()
                                .sorted()
                                .collect(StringBuilder::new,
                                         StringBuilder::appendCodePoint,
                                         StringBuilder::append).toString()));
        return new ArrayList<>(ret.values());
    }

    public List<List<String>> fastGroupAnagrams(String[] strs) {
        Map<String, List<String>> ret = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] key = s.toCharArray();
            Arrays.sort(key);
            String keyString = new String(key);
            if (ret.containsKey(keyString)) {
                ret.get(keyString).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                ret.put(keyString, l);
            }
        }
        return new ArrayList<>(ret.values());
    }
}
