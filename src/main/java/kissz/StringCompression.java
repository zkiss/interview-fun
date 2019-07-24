package kissz;

public class StringCompression {
    public static String compress(String s) {
        if (s.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();

        char c = s.charAt(0);
        for (int pos = 0; pos < s.length(); ) {

            int until = pos + 1;
            while (until < s.length() && s.charAt(until) == c) until++;

            sb.append(c).append(until - pos);

            pos = until;
            if (pos < s.length()) c = s.charAt(pos);
            if (sb.length() > s.length()) return s;
        }

        return sb.toString();
    }
}
