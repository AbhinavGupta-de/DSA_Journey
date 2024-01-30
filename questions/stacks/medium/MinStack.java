package questions.stacks.medium;

/**
 * MinStack
 */
public class MinStack {

 private class Stack {
  private class ListNode {
   int value;
   ListNode next;
   ListNode prev;

   ListNode(int value) {
    this.value = value;
   }
  }

  ListNode head;
  ListNode tail;
  ListNode min;

  Stack() {

  }

  void push(int value) {
   ListNode newNode = new ListNode(value);

   if (head == null) {
    this.head = newNode;
    this.tail = newNode;
    ListNode newNode2 = new ListNode(value);
    this.min = newNode2;

    return;
   }

   tail.next = newNode;
   tail.next.prev = tail;
   tail = tail.next;

   if (value <= min.value) {
    ListNode newNode2 = new ListNode(value);
    min.next = newNode2;
    min.next.prev = min;
    min = min.next;
   }
  }

  void pop() {

   if (this.tail.prev == null) {
    this.head = null;
    this.tail = null;
    this.min = null;

    return;
   }

   if (this.tail.value == this.min.value) {
    this.min = this.min.prev;
    this.min.next = null;
   }

   this.tail.prev.next = this.tail.next;
   this.tail = this.tail.prev;
  }

  int top() {
   if (this.tail != null) {
    return this.tail.value;
   }
   return -1;
  }

  int getMin() {
   if (this.min != null) {
    return this.min.value;
   }
   return -1;
  }

 }

 Stack stack = new Stack();

 public MinStack() {
 }

 public void push(int val) {
  stack.push(val);
 }

 public void pop() {
  stack.pop();
 }

 public int top() {
  return stack.top();
 }

 public int getMin() {
  return stack.getMin();
 }

}