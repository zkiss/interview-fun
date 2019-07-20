package kissz;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        Boolean[][] matches = new Boolean[s.length() + 1][p.length() + 1];
        return match(matches, s, 0, p, 0);
    }

    private boolean match(Boolean[][] matches, String s, int si, String p, int pi) {
        if (matches[si][pi] != null) return matches[si][pi];

        if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
            boolean currentMatch = si < s.length() &&
                    ('.' == p.charAt(pi) || s.charAt(si) == p.charAt(pi));
            matches[si][pi] = (currentMatch && match(matches, s, si + 1, p, pi)) ||
                    match(matches, s, si, p, pi + 2);
        } else if (si == s.length()) {
            matches[si][pi] = pi == p.length();
        } else if (pi == p.length()) {
            matches[si][pi] = false;
        } else if (p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si)) {
            matches[si][pi] = match(matches, s, si + 1, p, pi + 1);
        } else {
            matches[si][pi] = false;
        }
        return matches[si][pi];
    }
}
