import java.util.*;

public class phoneKeypad {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        
        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", 
            "mno", "pqrs", "tuv", "wxyz"
        };
        
        helper(digits, "", 0, ans, map);
        return ans;
    }

    private static void helper(String digits, String output, int idx, 
                               List<String> ans, String[] map) {
        if (idx == digits.length()) {
            ans.add(output);
            return;
        }
        
        int n = digits.charAt(idx) - '0';
        String value = map[n];
        
        for (int i = 0; i < value.length(); i++) {
            helper(digits, output + value.charAt(i), idx + 1, ans, map);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter digits (2-9): ");
        String digits = sc.nextLine();

        List<String> result = letterCombinations(digits);

        System.out.println("Letter Combinations: " + result);
        
        sc.close();
    }
}
