import java.util.Scanner;

public class trailingzeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        int result = trailingZeroes(n);
        System.out.println("Number of trailing zeroes in " + n + "! = " + result);
        
        sc.close();
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
