package kissz;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {

    private GenerateParentheses gp = new GenerateParentheses();

    @Test
    public void example() {
        assertEquals(
                new HashSet<>(Arrays.asList(
                        "((()))",
                        "(()())",
                        "(())()",
                        "()(())",
                        "()()()"
                )),
                new HashSet<>(gp.generateParenthesis(3))
        );
        assertEquals(
                new HashSet<>(Arrays.asList(
                        "(((())))",
                        "((()()))",
                        "((())())",
                        "((()))()",
                        "(()(()))",
                        "(()()())",
                        "(()())()",
                        "(())(())",
                        "(())()()",
                        "()((()))",
                        "()(()())",
                        "()(())()",
                        "()()(())",
                        "()()()()"
                )),
                new HashSet<>(gp.generateParenthesis(4))
        );
    }

}