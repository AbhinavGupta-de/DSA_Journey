package questions.tries.medium;

import java.util.HashMap;

public class MaximumXORSubarray {

 private class Trie {

  HashMap<Integer, Trie> map;
  int index;

  public Trie() {
   map = new HashMap<>();
   index = -1;
  }

  public void insert(int num, int index) {
   Trie curr = this;
   for (int i = 31; i >= 0; i--) {
    int bit = ((num >> i) & 1);
    if (!curr.map.containsKey(bit)) {
     curr.map.put(bit, new Trie());
    }

    curr = curr.map.get(bit);
   }
   curr.index = index;
  }

  public int getMaxXOR(int num) {

   Trie curr = this;

   for(int i = 31; i >= 0; i-- {
    
   }


  }
 }

 public int[] solve(int[] A) {

  // get the preffix XOR
  private int[] preffixXOR = preffixXOR(A);

  private int max = Integer.MIN_VALUE;

  for (int i = 0; i < preffixXOR.length; i++) {
   int max_xor = getMaxXOR(preffixXOR[i], root);
  }

 }

}
