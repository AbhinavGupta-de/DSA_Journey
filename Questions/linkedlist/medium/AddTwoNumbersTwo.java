package questions.linkedlist.medium;

public class AddTwoNumbersTwo {

 private class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
   this.val = val;
  }
 }

 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  ListNode head1 = reverse(l1);
  ListNode head2 = reverse(l2);

  ListNode result = addTwoNumber(head1, head2);

  return reverse(result);
 }

 public ListNode addTwoNumber(ListNode l1, ListNode l2) {
  int carry = 0;

  ListNode currentNode1 = l1;
  ListNode currentNode2 = l2;

  ListNode dummy = new ListNode(); // Use a dummy node for the result
  ListNode result = dummy;

  while (currentNode1 != null || currentNode2 != null) {
   int x = (currentNode1 != null) ? currentNode1.val : 0;
   int y = (currentNode2 != null) ? currentNode2.val : 0;

   int sum = carry + x + y;
   carry = sum / 10;
   result.next = new ListNode(sum % 10);
   result = result.next;

   if (currentNode1 != null)
    currentNode1 = currentNode1.next;
   if (currentNode2 != null)
    currentNode2 = currentNode2.next;
  }

  if (carry > 0) {
   result.next = new ListNode(carry);
  }

  return dummy.next;
 }

 public ListNode reverse(ListNode head) {
  ListNode prev = null;
  ListNode current = head;
  ListNode next = null;

  while (current != null) {
   next = current.next;
   current.next = prev;
   prev = current;
   current = next;
  }

  return prev;
 }
}
