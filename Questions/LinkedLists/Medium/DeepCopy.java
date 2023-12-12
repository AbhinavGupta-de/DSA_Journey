package Questions.LinkedLists.Medium;

import java.util.HashMap;

public class DeepCopy {

 private class RandomListNode {
  int label;
  RandomListNode next, random;

  RandomListNode(int x) {
   this.label = x;
   next = null;
   random = null;
  }
 }

 public RandomListNode copyRandomList(RandomListNode head) {

  HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

  // RandomListNode pointer = head;

  // RandomListNode newHead = new RandomListNode(0);
  // RandomListNode newPointer = newHead;

  // while (pointer != null) {
  // newPointer.next = new RandomListNode(pointer.label);
  // map.put(pointer.label, newPointer.next);
  // newPointer = newPointer.next;
  // pointer = pointer.next;
  // }

  // pointer = head;
  // newPointer = newHead.next;

  // while (pointer != null) {
  // newPointer.random = map.get(pointer.random.label);
  // newPointer = newPointer.next;
  // pointer = pointer.next;
  // }

  // return newHead.next;

  if (head == null)
   return null;

  RandomListNode pointer = head;

  while (pointer != null) {
   map.put(pointer, new RandomListNode(pointer.label));
   pointer = pointer.next;
  }

  pointer = head;

  while (pointer != null) {
   map.get(pointer).next = map.get(pointer.next);
   map.get(pointer).random = map.get(pointer.random);
   pointer = pointer.next;
  }

  return map.get(head);

 }

}
