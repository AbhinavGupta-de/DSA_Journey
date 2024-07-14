public class MaximumPrimeDifference {
    public int maximumPrimeDifference(int[] nums) {

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        boolean[] primes = new boolean[max + 1];
        primes[0] = true;
        primes[1] = true;
        for(int i = 2; i * i <= max; i++) {
            if(!primes[i]) {
                for(int j = i * 2; j <= max; j += i) {
                    primes[j] = true;
                }
            }
        }

        int l = -1;
        int r = -1;

        for (int i = 0; i < nums.length; i++) {
            if(!primes[nums[i]]) {
               l = i;
               break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if(!primes[nums[i]]) {
               r = i;
               break;
            }
        }

        if(l == -1 || r == -1) {
            return -1;
        }

        return  r - l;
    }
}