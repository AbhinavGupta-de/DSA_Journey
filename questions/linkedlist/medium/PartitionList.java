package questions.linkedlist.medium;

import questions.linkedlist.ListNode;

public class PartitionList {
 public ListNode partition(ListNode head, int x) {
  ListNode lessList = new ListNode(x);
  ListNode moreList = new ListNode(x);

  ListNode leCurrent = lessList;
  ListNode moCurrent = moreList;
  ListNode current = head;

  while (current != null) {
   if (current.val < x) {
    leCurrent.next = current;
    leCurrent = leCurrent.next;
   } else {
    moCurrent.next = current;
    moCurrent = moCurrent.next;
   }

   ListNode temp = current;
   current = current.next;
   temp.next = null;
  }

  moreList = moreList.next;
  lessList = lessList.next;

  if (lessList == null)
   return moreList;

  leCurrent.next = moreList;

  return lessList;
 }
}
