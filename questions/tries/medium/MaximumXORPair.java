package questions.tries.medium;

public class MaximumXORPair {

 private class TrieNode {
  TrieNode left;
  TrieNode right;
 }

 // using trie
 public int findMaximumXOR(int arr[]) {

  int n = arr.length;

  TrieNode root = new TrieNode();

  // First insert all the elements in the trie in binary form
  for (int i = 0; i < n; i++) {
   int num = arr[i];
   TrieNode curr = root;
   for (int j = 31; j >= 0; j--) {
    int bit = (num >> j) & 1;
    if (bit == 0) {
     if (curr.left == null) {
      curr.left = new TrieNode();
     }
     curr = curr.left;
    } else {
     if (curr.right == null) {
      curr.right = new TrieNode();
     }
     curr = curr.right;
    }
   }
  }

  // Now for each element find the maximum xor with any other element
  int max_xor = Integer.MIN_VALUE;

  for (int i = 0; i < n; i++) {
   int num = arr[i];
   TrieNode curr = root;
   int curr_xor = 0;
   for (int j = 31; j >= 0; j--) {
    int bit = (num >> j) & 1;
    if (bit == 0) {
     if (curr.right != null) {
      curr_xor += (int) Math.pow(2, j);
      curr = curr.right;
     } else {
      curr = curr.left;
     }
    } else {
     if (curr.left != null) {
      curr_xor += (int) Math.pow(2, j);
      curr = curr.left;
     } else {
      curr = curr.right;
     }
    }
   }
   max_xor = Math.max(max_xor, curr_xor);
  }

  return max_xor;

 }

}
