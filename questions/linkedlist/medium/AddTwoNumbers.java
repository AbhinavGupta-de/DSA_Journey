package questions.linkedlist.medium;

public class AddTwoNumbers {

 private class ListNode {
  int value;
  ListNode next;

  ListNode(int val) {
   this.value = val;
  }

  ListNode() {

  }
 }

 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

  int carry = 0;

  ListNode currentNode1 = l1;
  ListNode currentNode2 = l2;

  ListNode result = new ListNode();
  ListNode head = result;

  while (currentNode1.next != null && currentNode2.next != null) {
   int sum = carry + (currentNode1.value + currentNode2.value);
   int digit = sum % 10;
   carry = sum / 10;
   ListNode newNode = new ListNode(digit);
   result.next = newNode;
   result = result.next;
   currentNode1 = currentNode1.next;
   currentNode2 = currentNode2.next;
  }

  while (currentNode1.next != null) {
   int sum = currentNode1.value + carry;
   int digit = sum % 10;
   carry = sum / 10;
   ListNode newNode = new ListNode(digit);
   result.next = newNode;
   result = result.next;
   currentNode1 = currentNode1.next;
  }

  while (currentNode2 != null) {
   int sum = currentNode2.value + carry;
   int digit = sum % 10;
   carry = sum / 10;
   ListNode newNode = new ListNode(digit);
   result.next = newNode;
   currentNode2 = currentNode2.next;
   result = result.next;
  }

  if (carry != 0) {
   ListNode newNode = new ListNode(carry);
   result.next = newNode;
   result = result.next;
  }

  return head.next;
 }

}
