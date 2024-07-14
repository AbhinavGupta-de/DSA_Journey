public class PrimePalindrome {

    private boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;

    }

    public int primePalindrome(int n) {

        while (true) {
            if (isPalindrome(n) && isPrime(n)) {
                return n;
            }
            n++;
            if (10000000 < n && n < 100000000) {
                n = 100000000;
            }
        }

    }
}