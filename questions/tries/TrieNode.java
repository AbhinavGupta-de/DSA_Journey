package questions.tries;

import java.util.HashMap;

public class TrieNode {

 public HashMap<Object, TrieNode> children;
 public boolean isEnd;

 public TrieNode() {
  children = new HashMap<>();
  isEnd = false;
 }

 public TrieNode get(Object c) {
  return children.get(c);
 }

 public void put(Object c, TrieNode node) {
  children.put(c, node);
 }

}
