class Solution {
    public char mostFrequentChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        char res = ' ';
        int max = 0;
        for (var e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                res = e.getKey();
            }
        }
        return res;
    }
}
