package questions.linkedlist.medium;

public class SwapKthNode {
 private class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
   this.val = val;
  }
 }

 public ListNode swapNodes(ListNode head, int k) {
  if (head == null || k <= 0) {
   return head;
  }

  int size = 0;
  ListNode temp = head;
  while (temp != null) {
   size++;
   temp = temp.next;
  }

  if (k > size) {
   return head;
  }

  ListNode kthFromStart = findKthNode(head, k);
  ListNode kthFromEnd = findKthNode(head, size - k + 1);

  int tempVal = kthFromStart.val;
  kthFromStart.val = kthFromEnd.val;
  kthFromEnd.val = tempVal;

  return head;
 }

 private ListNode findKthNode(ListNode head, int k) {
  ListNode temp = head;
  for (int i = 1; i < k; i++) {
   temp = temp.next;
  }
  return temp;
 }
}
