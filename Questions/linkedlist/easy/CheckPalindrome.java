package questions.linkedlist.easy;

public class CheckPalindrome {

 public boolean isPalindrome(ListNode head) {

  if (head.next == null)
   return true;

  ListNode slow = head;
  ListNode fast = head.next;
  ListNode prev = null;
  ListNode next = null;

  while (fast != null && fast.next != null) {
   fast = fast.next.next;

   next = slow.next;
   slow.next = prev;
   prev = slow;
   slow = next;
  }
  boolean odd = false;
  if (fast == null)
   odd = true;

  next = slow.next;
  slow.next = prev;

  ListNode mid = slow;
  if (slow != null)
   System.out.println(slow.val);

  ListNode revCurrent = mid;
  ListNode currentHead = next;

  if (odd) {

   revCurrent = mid.next;
   currentHead = next;
  }

  while (revCurrent != null && currentHead != null) {
   if (currentHead.val != revCurrent.val)
    return false;

   currentHead = currentHead.next;
   revCurrent = revCurrent.next;
  }

  if (revCurrent != null && currentHead == null)
   return false;
  else if (revCurrent == null && currentHead != null)
   return false;

  return true;
 }

}
