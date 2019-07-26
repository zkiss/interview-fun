package kissz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List[] solutions = new List[n + 1];
        solutions[0] = Arrays.asList("");
        return gen(solutions, n);
    }

    private List<String> gen(List[] solutions, int n) {
        if (solutions[n] != null) return solutions[n];

        List<String> sn = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (String inner : gen(solutions, i))
                for (String remaining : gen(solutions, n - 1 - i))
                    sn.add("(" + inner + ")" + remaining);
        }
        solutions[n] = sn;

        return solutions[n];
    }
}
