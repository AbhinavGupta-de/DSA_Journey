import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long pow = sc.nextLong();

            try {
                System.out.println(power(n, pow));
            } catch (ArithmeticException e) {
                System.out.println("Overflow occurred");
            }
        }
    }

    private static long power(long n, long pow) {
        if (pow == 0) return 1;
        if (pow < 0) throw new IllegalArgumentException("Exponent should be non-negative");

        if (pow % 2 == 0) {
            long half = power(n, pow / 2);
            return safeMultiply(half, half);
        } else {
            return safeMultiply(n, power(n, pow - 1));
        }
    }

    private static long safeMultiply(long a, long b) {
        if (a > 0 ? b > Long.MAX_VALUE / a || b < Long.MIN_VALUE / a
                : (a < -1 ? b > Long.MIN_VALUE / a || b < Long.MAX_VALUE / a
                : a == -1 && b == Long.MIN_VALUE)) {
            throw new ArithmeticException("Overflow occurred");
        }
        return a * b;
    }
}
