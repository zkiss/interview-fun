package kissz;

/**
 * https://leetcode.com/problems/roman-to-integer
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int value = 0;
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == 'M') {
            value += 1000;
            ++i;
        }
        if (n - i > 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
            value += 900;
            i += 2;
        }
        if (i < n && s.charAt(i) == 'D') {
            value += 500;
            ++i;
        }
        if (n - i > 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
            value += 400;
            i += 2;
        }

        while (i < n && s.charAt(i) == 'C') {
            value += 100;
            ++i;
        }
        if (n - i > 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
            value += 90;
            i += 2;
        }
        if (i < n && s.charAt(i) == 'L') {
            value += 50;
            ++i;
        }
        if (n - i > 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
            value += 40;
            i += 2;
        }

        while (i < n && s.charAt(i) == 'X') {
            value += 10;
            ++i;
        }
        if (n - i > 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
            value += 9;
            i += 2;
        }
        if (i < n && s.charAt(i) == 'V') {
            value += 5;
            ++i;
        }
        if (n - i > 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
            value += 4;
            i += 2;
        }

        while (i < n && s.charAt(i) == 'I') {
            value += 1;
            ++i;
        }

        return value;
    }
}
