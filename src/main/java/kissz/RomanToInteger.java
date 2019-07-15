package kissz;

public class RomanToInteger {
    public int romanToInt(String s) {
        int value = 0;
        while (!s.isEmpty() && s.charAt(0) == 'M') {
            value += 1000;
            s = s.substring(1);
        }
        if (s.length() > 1 && s.startsWith("CM")) {
            value += 900;
            s = s.substring(2);
        }
        if (!s.isEmpty() && s.charAt(0) == 'D') {
            value += 500;
            s = s.substring(1);
        }
        if (s.length() > 1 && s.startsWith("CD")) {
            value += 400;
            s = s.substring(2);
        }

        while (!s.isEmpty() && s.charAt(0) == 'C') {
            value += 100;
            s = s.substring(1);
        }
        if (s.length() > 1 && s.startsWith("XC")) {
            value += 90;
            s = s.substring(2);
        }
        if (!s.isEmpty() && s.charAt(0) == 'L') {
            value += 50;
            s = s.substring(1);
        }
        if (s.length() > 1 && s.startsWith("XL")) {
            value += 40;
            s = s.substring(2);
        }

        while (!s.isEmpty() && s.charAt(0) == 'X') {
            value += 10;
            s = s.substring(1);
        }
        if (s.length() > 1 && s.startsWith("IX")) {
            value += 9;
            s = s.substring(2);
        }
        if (!s.isEmpty() && s.charAt(0) == 'V') {
            value += 5;
            s = s.substring(1);
        }
        if (s.length() > 1 && s.startsWith("IV")) {
            value += 4;
            s = s.substring(2);
        }
        while (!s.isEmpty() && s.charAt(0) == 'I') {
            value += 1;
            s = s.substring(1);
        }

        return value;
    }
}
