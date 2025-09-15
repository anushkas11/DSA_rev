import java.util.*;
public class pow {
    public static double myPow(double x, int n) {
        long exp = n; 
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        return power(x, exp);
    }

    private static double power(double x, long n) {
        if (n == 0) return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        double x=sc.nextDouble();
        System.err.println("Enter power");
        int n=sc.nextInt();
        System.out.println(myPow(x,n));  

    }
}

