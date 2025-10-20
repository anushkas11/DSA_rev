import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] count = new int[26];
        for (char c : p.toCharArray()) count[c - 'a']++;
        int left = 0, right = 0, toMatch = p.length();
        while (right < s.length()) {
            if (count[s.charAt(right++) - 'a']-- > 0) toMatch--;
            if (toMatch == 0) res.add(left);
            if (right - left == p.length() && count[s.charAt(left++) - 'a']++ >= 0) toMatch++;
        }
        return res;
    }
}
