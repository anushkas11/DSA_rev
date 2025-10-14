import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 3, 5, 1};
        
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        
        for (int num : nums) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        
        System.out.println("Repeating elements: " + duplicates);
    }
}
