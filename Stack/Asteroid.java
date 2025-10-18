import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop(); // right-moving asteroid explodes
                } else if (stack.peek() == -ast) {
                    stack.pop(); // both explode
                    destroyed = true;
                    break;
                } else { // stack.peek() > -ast
                    destroyed = true; // left-moving asteroid explodes
                    break;
                }
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert stack to array (reverse order)
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
