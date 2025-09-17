public class fact {
    // Recursive method to calculate factorial
    static long fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static void main(String[] args) {
        int number = 5; // change this number to test
        System.out.println("Factorial of " + number + " = " + fact(number));
    }
}
