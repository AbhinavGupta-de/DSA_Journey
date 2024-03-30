package heaps.hard;

import java.util.PriorityQueue;

import linkedlist.ListNode;

public class MergeKSortedLists {
 public ListNode mergeKLists(ListNode[] lists) {

  PriorityQueue<Integer> q = new PriorityQueue<>();

  for (ListNode i : lists) {
   ListNode curr = i;
   while (curr != null) {
    q.add(curr.val);
    curr = curr.next;
   }
  }

  ListNode root = new ListNode(q.poll());

  ListNode temp = root;

  while (!q.isEmpty()) {
   temp.next = new ListNode(q.poll());
   temp = temp.next;
  }

  return root;
 }
}
