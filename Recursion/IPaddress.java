import java.util.*;

public class IPaddress {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n < 4 || n > 12) return res;
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void helper(String s, int st, List<String> parts, List<String> res) {
        if (parts.size() == 4) {
            if (st == s.length()) {
                res.add(String.join(".", parts));
            }
            return;
        }

        int remParts = 4 - parts.size();
        int remCh = s.length() - st;
        if (remCh < remParts || remCh > 3 * remParts) return;

        for (int l = 1; l <= 3; l++) {
            if (st + l > s.length()) break;
            String seg = s.substring(st, st + l);
            if (isValid(seg)) {
                parts.add(seg);
                helper(s, st + l, parts, res);
                parts.remove(parts.size() - 1);
            }
        }
    }

    private static boolean isValid(String seg) {
        if (seg.length() > 1 && seg.charAt(0) == '0') return false;
        int val = Integer.parseInt(seg);
        return val <= 255;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result = restoreIpAddresses(s);
        System.out.println(result);
    }
}
