package Questions.LinkedLists.Hard;

/**
 * This class implements the merge sort algorithm for a linked list.
 */
public class MergeSortLinkedLIst {

 public ListNode sortList(ListNode head) {
  if (head == null || head.next == null) {
   return head;
  }
  ListNode mid = getMid(head);
  ListNode left = sortList(head);
  ListNode right = sortList(mid);
  return merge(left, right);
 }

 public ListNode merge(ListNode list1, ListNode list2) {

  if (list1 == null || list2 == null) {
   if (list1 == null && list2 != null) {
    return list2;
   } else if (list2 == null && list1 != null)
    return list1;
   else
    return null;
  }

  ListNode current = null;

  if (list1.val < list2.val) {
   current = list1;
   list1 = list1.next;
  } else {
   current = list2;
   list2 = list2.next;
  }

  current.next = merge(list1, list2);

  return current;

 }

 public ListNode getMid(ListNode head) {
  ListNode midPrev = null;
  while (head != null && head.next != null) {
   midPrev = (midPrev == null) ? head : midPrev.next;
   head = head.next.next;
  }

  // The most important line in this whole code
  // This line is used to break the link between the two lists
  // This is done so that the two lists can be sorted independently
  // and then merged
  ListNode mid = midPrev.next;
  midPrev.next = null;
  return mid;
 }

 public static void main(String[] args) {
  MergeSortLinkedLIst mergeSortLinkedLIst = new MergeSortLinkedLIst();
  ListNode head = new ListNode(5);
  head.next = new ListNode(4);
  head.next.next = new ListNode(3);
  head.next.next.next = new ListNode(1);
  head.next.next.next.next = new ListNode(2);
  head.next.next.next.next.next = new ListNode(23);
  head.next.next.next.next.next.next = new ListNode(15);
  head.next.next.next.next.next.next.next = new ListNode(9);
  head.next.next.next.next.next.next.next.next = new ListNode(0);
  ListNode result = mergeSortLinkedLIst.sortList(head);
  while (result != null) {
   System.out.print(result.val + " ");
   result = result.next;
  }
  System.out.println();
  head = new ListNode(4);
  head.next = new ListNode(2);
  head.next.next = new ListNode(1);
  head.next.next.next = new ListNode(3);
  result = mergeSortLinkedLIst.sortList(head);
  while (result != null) {
   System.out.print(result.val + " ");
   result = result.next;
  }
  System.out.println();
  head = new ListNode(-1);
  head.next = new ListNode(5);
  head.next.next = new ListNode(3);
  head.next.next.next = new ListNode(4);
  head.next.next.next.next = new ListNode(0);
  result = mergeSortLinkedLIst.sortList(head);
  while (result != null) {
   System.out.print(result.val + " ");
   result = result.next;
  }
  System.out.println();
  head = new ListNode(1);
  head.next = new ListNode(2);
  head.next.next = new ListNode(3);
  head.next.next.next = new ListNode(4);
  result = mergeSortLinkedLIst.sortList(head);
  while (result != null) {
   System.out.print(result.val + " ");
   result = result.next;
  }
  System.out.println();
  head = new ListNode(1);
  head.next = new ListNode(2);
  result = mergeSortLinkedLIst.sortList(head);
  while (result != null) {
   System.out.print(result.val + " ");
   result = result.next;
  }
  System.out.println();
  head = new ListNode(2);
  head.next = new ListNode(1);
 }
}
