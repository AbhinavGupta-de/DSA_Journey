import java.io.*;
import java.util.*;

public class CommonDivisors {
    public static final int MAX_VAL = 1000000;

    public static int[] divisors = new int[MAX_VAL + 1];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(io.readLine());

        int[] arr = Arrays.stream(io.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n; i++) {
            int up = (int)Math.sqrt(arr[i]);
            for (int div = 1; div <= up; div++) {
                if (arr[i] % div == 0) {
                    divisors[div]++;
                    if (div != arr[i] / div) { divisors[arr[i] / div]++; }
                }
            }
        }

        for (int i = MAX_VAL; i >= 1; i--) {
            if (divisors[i] >= 2) {
                System.out.println(i);
                break;
            }
        }
    }
}