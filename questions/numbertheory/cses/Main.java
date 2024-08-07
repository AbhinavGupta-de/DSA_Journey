import java.util.*;
import java.io.*;

public class Main {
    private static final long MOD = 1000000007;

    public static long createString(String s) {
        long[] freq = new long[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        long fact = factorial(s.length());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                fact = (fact * modInverse(factorial((int) freq[i]), MOD)) % MOD;
            }
        }

        return fact;
    }

    private static long factorial(int n) {
        long fact = 1L;
        for (int i = 1; i <= n; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }

    private static long power(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
        }
        return res;
    }

    private static long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        String s = io.readLine();
        System.out.println(createString(s));
        io.close();
    }
}
