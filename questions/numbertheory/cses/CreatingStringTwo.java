public class CreatingStringTwo {

    public static long createString(String s) {

        long[] freq = new long[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        long fact = factorial(s.length());
        long mod = 1000000007;
        for (int i = 0; i < 26; i++) {
            fact = (fact * modInverse((int) factorial((int) freq[i]), (int) mod)) % mod;
        }

        return fact;
    }

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private static long power(int a, int b, int mod) {

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

    private static long modInverse(int a, int mod) {
        return power(a, mod - 2, mod);
    }

}