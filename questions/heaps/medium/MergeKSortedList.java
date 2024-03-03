package heaps.medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

import linkedlist.ListNode;

public class MergeKSortedList {
 public ListNode mergeKLists(ArrayList<ListNode> heads) {

  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  for (ListNode head : heads) {
   while (head != null) {
    minHeap.add(head.val);
    head = head.next;
   }
  }

  ListNode root = new ListNode(minHeap.poll());
  ListNode curr = root;

  while (!minHeap.isEmpty()) {
   ListNode newNode = new ListNode(minHeap.poll());
   curr.next = newNode;
   curr = curr.next;
  }
  return root;
 }
}
