public class RemoveDuplicates {
    
    // Used as index in the modified string
    public static String removeDuplicate(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        boolean[] seen = new boolean[256];

        // Traverse through all characters
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check if s[i] is present before it  
            if (!seen[c]) {
                sb.append(c);
                seen[c] = true;
            }
        }
        
        return sb.toString();
    }

    // Driver code
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(removeDuplicate(s));
    }
}