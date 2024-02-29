package heaps.hard;

import java.util.PriorityQueue;

public class FindMedianOfDataStream {

 PriorityQueue<Integer> minHeap = new PriorityQueue<>();
 PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

 boolean isEven;

 public FindMedianOfDataStream() {
  isEven = true;
 }

 public void addNum(int num) {
  if (isEven) {
   this.minHeap.offer(num);
   this.maxHeap.offer(this.minHeap.poll());
  } else {
   this.maxHeap.offer(num);
   this.minHeap.offer(this.maxHeap.poll());
  }

  isEven = !isEven;
 }

 public double findMedian() {
  return isEven ? (this.minHeap.peek() + this.maxHeap.peek()) / 2.0 : this.maxHeap.peek();
 }
}
