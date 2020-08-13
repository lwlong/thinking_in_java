package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  https://leetcode.com/problems/find-median-from-data-stream/
 *  295. Find Median from Data Stream
 *  Hard
 *
 *  代码面试指南 P516 随时找到数据流的中位数
 *  左大根堆 右小根堆
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.maxHeap.size());
        System.out.println(m.minHeap.size());
        System.out.println(m.findMedian());
    }
}

class MedianFinder {

    public class MinHeapComparator implements Comparator<Integer>{
        //            @Override
        public int compare(Integer o1, Integer o2){
            return o1 - o2;
        }
    }

    public class MaxHeapComparator implements Comparator<Integer>{
        //            @Override
        public int compare(Integer o1, Integer o2){
            return o2 - o1;
        }
    }

    public PriorityQueue<Integer> maxHeap;
    public PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(11, new MaxHeapComparator());
        minHeap = new PriorityQueue<Integer>(11, new MinHeapComparator());//默认就是小顶堆
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        modifyTwoHeaps();
    }

    public double findMedian() {
        if(maxHeap.isEmpty()){
            return -1;
        }
        if(maxHeap.size() == minHeap.size()){
            return ((double)(maxHeap.peek()+minHeap.peek()))/2;
        }else{
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }

    private void modifyTwoHeaps(){
        if(maxHeap.size() == minHeap.size()+2){
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size() == maxHeap.size()+2){
            maxHeap.add(minHeap.poll());
        }
    }
}
