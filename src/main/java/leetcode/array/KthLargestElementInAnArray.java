package leetcode.array;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  https://leetcode.com/problems/kth-largest-element-in-an-array/
 *  215. Kth Largest Element in an Array
 *  代码面试指南 数组和矩阵 P366
 *  Input: [3,2,1,5,6,4] and k = 2
 *  Output: 5
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};

//        int result = findKthLargestByPriorityQueue(nums,2);

        int result = findKthLargest(nums, 4);
        System.out.println(result);

    }



    public static int findKthLargestByPriorityQueue(int[] nums, int k) {
        if(k<1 || k>nums.length){
            return -1;
        }
//        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //小顶堆，默认容量为11
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
//            @Override
            public int compare(Integer i1 , Integer i2){
                return i2 - i1;
            }
        });
        for(int i=0; i<nums.length; i++){
            maxHeap.add(nums[i]);
        }
        int result = -1;
        for(int i=0;i<k;i++){
            result = maxHeap.poll();
        }
        return result;
    }


    public static int findKthLargest(int[] nums, int k) {
        if(k<1 || k>nums.length){
            return -1;
        }
        int[] kHeap = new int[k];
        for(int i=0; i!=k; i++){
            heapInsert(kHeap, nums[i], i);
        }
        for(int i=k; i!=nums.length; i++){
            if(nums[i]>kHeap[0]){
                kHeap[0] = nums[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap[0];
    }

    public static void heapInsert(int[] arr, int value, int index){
        arr[index] = value;
        while(index != 0){
            int parent = (index-1)/2;
            if(arr[parent]>arr[index]){
                swap(arr, parent, index);
                index = parent;
            }else{
                break;
            }
        }
    }

    public static void heapify(int[] arr, int index, int heapSize){
        int left = index*2+1;
        int right = index*2+2;
        int small = index;
        while(left<heapSize){
            if(arr[left]<arr[index]){
                small = left;
            }
            if(right<heapSize && arr[right]<arr[small]){
                small = right;
            }
            if(small!=index){
                swap(arr, small, index);
            }else{
                break;
            }
            index = small;
            left = index*2+1;
            right = index*2+2;
        }

    }

    public static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
