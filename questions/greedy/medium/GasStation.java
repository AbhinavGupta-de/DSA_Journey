package greedy.medium;

public class GasStation {
 public int canCompleteCircuit(int[] gas, int[] cost) {
  int[] opp = new int[gas.length];
  int sum = 0;

  for (int i = 0; i < gas.length; i++) {
   opp[i] = gas[i] - cost[i];
   sum += opp[i];
  }

  if (sum < 0)
   return -1;

  int total = 0;
  int result = 0;
  for (int i = 0; i < gas.length; i++) {
   total += opp[i];

   if (total < 0) {
    total = 0;
    result = i + 1;
   }
  }

  return result;
 }
}
