package heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

 private ArrayList<T> list;

 public Heap() {
  list = new ArrayList<>();
 }

 private void swap(int swap1, int swap2) {
  T temp = list.get(swap1);
  list.set(swap1, list.get(swap2));
  list.set(swap2, temp);
 }

 private int parent(int index) {
  return (index - 1) / 2;
 }

 private int left(int index) {
  return index * 2 + 1;
 }

 private int right(int index) {
  return (index + 1) * 2;
 }

 public void insert(T value) {
  list.add(value);
  upHeap(list.size() - 1);
 }

 private void upHeap(int index) {
  if (index == 0)
   return;

  int p = parent(index);
  if (list.get(index).compareTo(list.get(p)) < 0) {
   swap(index, p);
   upHeap(p);
  }
 }

 public T remove() throws Exception {
  if (list.isEmpty()) {
   throw new Exception("Removing from an empty heap!");
  }

  T temp = list.get(0);

  T last = list.remove(list.size() - 1);
  if (!list.isEmpty()) {
   list.set(0, last);
   downHeap(0);
  }

  return temp;
 }

 private void downHeap(int index) {

  if (index >= list.size())
   return;

  int l = left(index);
  int r = right(index);

  int min = min(l, r, index);

  if (min != index) {
   swap(index, min);
   downHeap(min);
  }

 }

 private int min(int index1, int index2, int defaultVal) {

  int min = defaultVal;

  if (list.get(min).compareTo(list.get(index1)) > 0 && index1 < list.size()) {
   min = index1;
  }

  if (list.get(min).compareTo(list.get(index2)) > 0 && index2 < list.size()) {
   min = index2;
  }

  return min;
 }

 public ArrayList<T> heapSort() throws Exception {
  ArrayList<T> data = new ArrayList<>();
  while (list.isEmpty()) {
   data.add(this.remove());
  }

  return data;
 }
}
