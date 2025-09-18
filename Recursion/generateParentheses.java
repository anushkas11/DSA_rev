import java.util.*;

public class generateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, n, 0, 0, "");
        return result;
    }

    private static void helper(List<String> result, int n, int open, int close, String output) {
        if (output.length() == 2 * n) {
            result.add(output);
            return;
        }
        if (open < n) {
            helper(result, n, open + 1, close, output + '(');
        }
        if (close < open) {
            helper(result, n, open, close + 1, output + ')');
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> result = generateParenthesis(n);
        for (String s : result) {
            System.out.println(s);
        }
        sc.close();
    }
}
