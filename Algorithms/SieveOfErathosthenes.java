package Algorithms;

// * c-ve of era-thos-then-es
public class SieveOfErathosthenes {

 public static int[] sieveOfErathosthenes(int n) {
  boolean[] isPrime = new boolean[n + 1];
  for (int i = 0; i <= n; i++)
   isPrime[i] = true;
  isPrime[0] = false;
  isPrime[1] = false;
  for (int i = 2; i * i <= n; i++) {
   if (isPrime[i]) {
    for (int j = i * i; j <= n; j += i)
     isPrime[j] = false;
   }
  }
  int count = 0;
  for (int i = 0; i <= n; i++) {
   if (isPrime[i])
    count++;
  }
  int[] primes = new int[count];
  int index = 0;
  for (int i = 0; i <= n; i++) {
   if (isPrime[i])
    primes[index++] = i;
  }
  return primes;
 }

}
