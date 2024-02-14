package questions.stacks.hard;

import java.util.Stack;

public class MaxMinInRange {
 public int shit(long z) {
  int MOD = (int) Math.pow(10, 9) + 7;
  return (int) ((z % MOD) + MOD) % MOD;
 }

 public int[] nextG(int[] A) {
  int n = A.length;
  Stack<Integer> st = new Stack<>();
  int arr[] = new int[A.length];

  for (int i = n - 1; i >= 0; i--) {
   while (!st.isEmpty() && A[st.peek()] < A[i]) {
    st.pop();
   }
   arr[i] = st.isEmpty() ? n : st.peek();
   st.push(i);
  }

  return arr;
 }

 public int[] nextS(int[] A) {
  int n = A.length;
  Stack<Integer> st = new Stack<>();
  int arr[] = new int[A.length];

  for (int i = n - 1; i >= 0; i--) {
   while (!st.isEmpty() && A[st.peek()] > A[i]) {
    st.pop();
   }
   arr[i] = st.isEmpty() ? n : st.peek();
   st.push(i);
  }

  return arr;
 }

 public int[] prevG(int[] A) {
  int n = A.length;
  Stack<Integer> st = new Stack<>();
  int arr[] = new int[A.length];

  for (int i = 0; i < n; i++) {
   while (!st.isEmpty() && A[st.peek()] < A[i]) {
    st.pop();
   }
   arr[i] = st.isEmpty() ? -1 : st.peek();
   st.push(i);
  }

  return arr;
 }

 public int[] prevS(int[] A) {
  int n = A.length;
  Stack<Integer> st = new Stack<>();
  int arr[] = new int[A.length];

  for (int i = 0; i < n; i++) {
   while (!st.isEmpty() && A[st.peek()] > A[i]) {
    st.pop();
   }
   arr[i] = st.isEmpty() ? -1 : st.peek();
   st.push(i);
  }

  return arr;
 }

 public int solve(int[] A) {

  int NG[] = nextG(A);
  int NS[] = nextS(A);
  int PG[] = prevG(A);
  int PS[] = prevS(A);

  long x = 0;
  long y = 0;
  for (int i = 0; i < A.length; i++) {
   x += (long) A[i];
   x = shit(x);
   x *= (i - PG[i]);
   x = shit(x);
   x *= (NG[i] - i);
   x = shit(x);
   y += (long) A[i];
   y = shit(y);
   y *= (i - PS[i]);
   y = shit(y);
   y *= (NS[i] - i);
   y = shit(y);

  }

  return (int) shit(x - y);
 }
}
