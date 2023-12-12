package Questions.LinkedLists.Hard;

/**
 * InnerMergeTwoSortedLists
 */

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    // if (list1 == null || list2 == null) {
    // if (list1 == null && list2 != null) {
    // return list2;
    // } else if (list2 == null && list1 != null)
    // return list1;
    // else
    // return null;
    // }

    // ListNode current = null;

    // if (list1.val < list2.val) {
    // current = list1;
    // list1 = list1.next;
    // } else {
    // current = list2;
    // list2 = list2.next;
    // }

    // current.next = mergeTwoLists(list1, list2);

    // return current;

    ListNode pointer1 = list1;
    ListNode pointer2 = list2;
    ListNode temp = null;

    if (list1.val < list2.val) {
      temp = list1;
      pointer1 = pointer1.next;
    } else {
      temp = list2;
      pointer2 = pointer2.next;
    }

    ListNode head = temp;

    while (pointer1 != null && pointer2 != null) {
      if (pointer1.val < pointer2.val) {
        temp.next = pointer1;
        temp = temp.next;

        pointer1 = pointer1.next;
      } else {
        temp.next = pointer2;
        temp = temp.next;
        pointer2 = pointer2.next;
      }
    }

    if (pointer1 == null) {
      temp.next = pointer2;

    } else {
      temp.next = pointer1;
    }

    return head;
  }

  public static void main(String[] args) {
    MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
    ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode result = mtsl.mergeTwoLists(list1, list2);
    int count = 8;
    while (result != null && count > 0) {
      count--;
      System.out.println(result.val);
      result = result.next;
    }
    System.out.println("Done");
    // System.out.println(mtsl.mergeTwoLists(list1, list2));
    // System.out.println(mtsl.mergeTwoLists(list1, list2));
    // System.out.println(mtsl.mergeTwoLists(list
  }
}
