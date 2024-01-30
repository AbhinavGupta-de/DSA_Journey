package questions.searching.hard;

/**
 * SmallestGoodBase
 */
public class SmallestGoodBase {

  public String smallestGoodBase(String n) {
    long N = Long.valueOf(n);
    long ans = N - 1;
    for (int i = log(N) + 1; i > 2; i--) {
      long m = findGoodBase(N, i);
      if (m != -1) {
        ans = m;
        break;
      }
    }

    return String.valueOf(ans);
  }

  public long findGoodBase(long N, int i) {
    long start = 2;
    long end = (long) (Math.pow(N, 1.0 / (i - 1)) + 1);

    while (start <= end) {
      long base = start + (end - start) / 2;
      long value = expand(base, i);

      if (value == N)
        return base;
      else if (value < N)
        start = base + 1;
      else
        end = base - 1;
    }

    return -1L;
  }

  public long expand(long base, long i) {
    long power = base;
    long value = power;

    for (int j = 2; j < i; j++) {
      power *= base;
      value += power;
    }

    return value + 1;
  }

  public int log(long n) {
    return (int) (Math.log(n) / Math.log(2));
  }
}