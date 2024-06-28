package questions.sieve;

public class CountingDivisors {
    public static void main(String[] args) {
        int max = 1000001;
        int[] divisors = new int[max];
        for(int i = 0; i < max; i++) {
            for(int j = i; j <= max; j += i) {
                divisors[j]++;
            }
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            System.out.println(divisors[x]);
        }
    }
}