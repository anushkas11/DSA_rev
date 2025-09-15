import java.util.Arrays;

public class revthestring {
    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        reverseString(arr);
        System.out.println(Arrays.toString(arr)); 
    }

    public static void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private static void helper(char[] s, int l, int m) {
        if (l >= m) return;  
        char ch = s[l];
        s[l] = s[m];
        s[m] = ch;
        helper(s, l + 1, m - 1); 
    }
}
