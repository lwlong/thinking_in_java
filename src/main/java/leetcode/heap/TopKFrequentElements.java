package leetcode.heap;

import java.util.HashMap;

/**
 *  https://leetcode.com/problems/top-k-frequent-elements/
 *  347. Top K Frequent Elements
 *  Medium
 *
 *  代码面试指南 P526
 *  出现次数的topK问题 HashMap 堆排
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

        int[] nums = new int[]{4,5,6,1,1,1,2,2,3};
        int[] result = topKFrequentElements.topKFrequent(nums, 3);
        for (int i:result) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || k<1){
            return new int[]{};
        }
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            Integer cur = nums[i];
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur)+1);
            }else{
                map.put(cur, 1);
            }
        }
        System.out.println(map);
        int[] heap = new int[k];
        int index = 0;
        for(Integer i: map.keySet()){
            Integer times = map.get(i);
            if(index < k){
                heap[index] = i;
                System.out.println("heap["+index+"]="+heap[index]);
                heapInsert(heap, map, index);
                index++;
            }else{
                if(map.get(heap[0]) < map.get(i)){
                    heap[0] = i;
                    System.out.println("heap[0]="+heap[0]);
                    heapify(heap, map, 0, k);
                }
            }
        }

        System.out.println("heap：");
        System.out.println("heap size："+heap.length);
        for (int i:heap) {
            System.out.print(i+" ");
        }
        System.out.println();

        //堆排 每次把最小的放到最后，然后向前循环
        System.out.println("堆排");
        for(int i=k-1; i>0; i--){
            swap(heap,0,i);
            heapify(heap,map,0,i);
        }

        System.out.println("heap：");
        System.out.println("heap size："+heap.length);
        for (int i:heap) {
            System.out.print(i+" ");
        }
        System.out.println();


        return heap;
    }

    public void heapInsert(int[] heap, HashMap<Integer,Integer> map, int index){
        while(index!=0){
            int parent = (index-1)/2;
            if(map.get(heap[index]) < map.get(heap[parent])){
                swap(heap, index, parent);
                index = parent;
            }else{
                break;
            }
        }
    }

    public void heapify(int[] heap, HashMap<Integer,Integer> map, int index, int heapSize){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while(left<heapSize){
            if(map.get(heap[left]) < map.get(heap[index])){
                smallest = left;
            }
            if(right<heapSize && map.get(heap[right]) < map.get(heap[smallest])){
                smallest = right;
            }
            if(smallest != index){
                swap(heap, smallest, index);
            }else{
                break;
            }
            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public void swap(int[] heap, int index1, int index2){
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }



}
