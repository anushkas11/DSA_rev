import java.util.*;

class Solution {
    public int evaluatePostfix(String[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : arr) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;

                switch (s) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = a / b; break;
                }

                stack.push(res);
            } else {
                // It's a number
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
