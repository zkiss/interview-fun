package kissz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();

        int comboCnt = 1;
        for (int i = 0; i < digits.length(); i++) {
            comboCnt *= letterCount(digits.charAt(i));
        }
        char[][] res = new char[comboCnt][digits.length()];

        for (int idx = 0; idx < res.length; idx++) {
            int offsetHelp = idx;
            for (int i = digits.length() - 1; i > -1; i--) {
                int offset = offsetHelp % letterCount(digits.charAt(i));
                offsetHelp /= letterCount(digits.charAt(i));
                char currentLetter = letter(digits.charAt(i), offset);
                res[idx][i] = currentLetter;
            }
        }

        LinkedList<String> list = new LinkedList<>();
        for (char[] r : res) list.add(new String(r));
        return list;
    }

    private int letterCount(char digit) {
        switch (digit) {
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '8':
                return 3;
            case '7':
            case '9':
                return 4;
            default:
                throw new IllegalArgumentException();
        }
    }

    private char letter(char digit, int letterId) {
        if (digit < '2' || digit > '9')
            throw new IllegalArgumentException();

        return (char) ((digit - '2') * 3 + 'a' + letterId);
    }
}
