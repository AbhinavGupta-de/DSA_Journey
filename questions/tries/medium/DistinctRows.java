package questions.tries.medium;

import questions.tries.TrieNode;

public class DistinctRows {

 // using trie

 public int countDistinct(int arr[][]) {

  int n = arr.length;
  int m = arr[0].length;

  TrieNode root = new TrieNode();

  int count = 0;

  for (int i = 0; i < n; i++) {

   TrieNode node = root;
   for (int j = 0; j < m; j++) {
    if (node.get(arr[i][j]) == null) {
     node.put(arr[i][j], new TrieNode());
    }
    node = node.get(arr[i][j]);
   }

   if (!node.isEnd) {
    count++;
    node.isEnd = true;
   }

  }

  return count;

 }

}
