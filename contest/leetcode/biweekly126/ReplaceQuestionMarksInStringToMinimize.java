package contest.leetcode.biweekly126;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReplaceQuestionMarksInStringToMinimize {

 private class Element {
  int index;
  int freq;

  public Element(int index, int value) {
   this.index = index;
   this.freq = value;
  }
 }

 public String minimizeStringValue(String s) {

  int[] freq = new int[26];

  int missing = 0;

  // Count the frequencies of each character
  for (char c : s.toCharArray()) {
   if (Character.isLetter(c)) {
    freq[c - 'a']++;
   }
   if (c == '?') {
    missing++;
   }
  }

  PriorityQueue<Element> q = new PriorityQueue<>((a, b) -> {
   if (a.freq == b.freq) {
    return a.index - b.index;
   }
   return a.freq - b.freq;
  });

  PriorityQueue<Element> q2 = new PriorityQueue<>((a, b) -> {
   if (a.freq == b.freq) {
    return a.index - b.index;
   }
   return a.freq - b.freq;
  });

  // Add the frequncy with the index to the priority queue
  for (int i = 0; i < 26; i++) {
   q.add(new Element(i, freq[i]));
  }

  int[] freq2 = new int[missing];
  for (int i = 0; i < missing; i++) {
   Element e = q.poll();
   e.freq++;
   q.add(e);
   freq2[i] = e.index;
  }

  Arrays.sort(freq2);

  // Replace '?' with the character that has the minimum frequency
  int count = 0;
  StringBuilder sb = new StringBuilder(s);
  for (int i = 0; i < sb.length(); i++) {
   if (sb.charAt(i) == '?') {
    sb.setCharAt(i, (char) (freq2[count++] + 'a'));
   }
  }
  return sb.toString();
 }

 public static void main(String[] args) {
  System.out.println(new ReplaceQuestionMarksInStringToMinimize().minimizeStringValue("abcdefghijklmnopqrstuvwxy??"));
 }
}
