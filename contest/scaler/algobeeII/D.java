package contest.scaler.algobeeII;

import java.util.*;

public class D {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  int n = sc.nextInt();

  int[] colors = new int[n];

  for (int i = 0; i < n; i++) {
   colors[i] = sc.nextInt();
  }

  int[] vals = new int[n];

  for (int i = 0; i < n; i++) {
   vals[i] = sc.nextInt();
  }

  /*
   * You are given an array A
   * of length N
   * .
   * 
   * Each element in the array is associated with a specific color. Additionally,
   * each element has a value assigned to it.
   * 
   * Your task is to sort the array in non-decreasing order of values, minimizing
   * the number of swaps.
   * 
   * Note: You can only swap two elements if they have the same color.
   * 
   * Input
   * The input consists of a single test case.
   * 
   * The first line contains an integer N
   * (1≤N≤105)
   * — the size of the array A
   * .
   * 
   * The second line contains N
   * integers C0,C1,…,CN−1
   * (1≤Ci≤N)
   * , where Ci
   * represents the color associated with the i
   * -th element of the array.
   * 
   * The third line contains N
   * integers V0,V1,…,VN−1
   * (1≤Vi≤109)
   * , where Vi
   * represents the value associated with the i
   * -th element of the array.
   * 
   * Output
   * If it is impossible to sort the array according to the conditions given,
   * print -1.
   * 
   * Otherwise, print K
   * — the minimum number of swaps required to sort the array. Then, print K
   * lines, each containing two integers i
   * and j
   * (0≤i,j<N)
   * , indicating that the i
   * -th and j
   * -th elements are swapped.
   * 
   */

  Map<Integer, List<Integer>> colorMap = new HashMap<>();

  for (int i = 0; i < n; i++) {
   if (colorMap.containsKey(colors[i])) {
    colorMap.get(colors[i]).add(i);
   } else {
    List<Integer> list = new ArrayList<>();
    list.add(i);
    colorMap.put(colors[i], list);
   }
  }

  List<Integer> sortedVals = new ArrayList<>();
  for (int i = 0; i < n; i++) {
   sortedVals.add(vals[i]);
  }

  Collections.sort(sortedVals);

  int swaps = 0;

  for (int i = 0; i < n; i++) {
   if (vals[i] != sortedVals.get(i)) {
    int color = colors[i];
    int index = colorMap.get(color).get(0);
    colorMap.get(color).remove(0);
    colorMap.get(color).add(i);
    colors[index] = colors[i];
    colors[i] = color;
    swaps++;
   }
  }

  System.out.println(swaps);

 }
}
