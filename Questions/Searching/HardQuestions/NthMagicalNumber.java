package Questions.Searching.HardQuestions;

public class NthMagicalNumber {
  public long nthMagicalNum(int n, int a, int b) {
    long min = Math.min(a, b);

    long start = min;
    long end = n * min;

    while (start < end) {
      long mid = start + (end - start) / 2;
      if (count(mid, a, b) < n)
        start = mid + 1;
      else
        end = mid;
    }

    return start % 1000000007;
  }

  public long count(long num, long a, long b) {
    return (num / a) + (num / b) - (num / lcm(a, b));
  }

  public long lcm(long a, long b) {
    return (a * b) / gcd(a, b);
  }

  public long gcd(long a, long b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    NthMagicalNumber obj = new NthMagicalNumber();
    long n = obj.nthMagicalNum(807414236, 3788, 38141);
    System.out.println(n);
  }
}
