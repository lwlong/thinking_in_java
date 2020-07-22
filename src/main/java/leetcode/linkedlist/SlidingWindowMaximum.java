package leetcode.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  https://leetcode.com/problems/sliding-window-maximum/
 *  239. Sliding Window Maximum 滑动窗口最大值
 *  Hard
 *  代码面试指南 P18 生成窗口最大值数组 双端队列
 *
 *  输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 *  输出: [3,3,5,5,6,7]
 *  解释:

 *  滑动窗口的位置                最大值
 *  ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7

 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] result = swm.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Runtime: 17 ms, faster than 39.95% of Java online submissions for Sliding Window Maximum.
     * Memory Usage: 63.3 MB, less than 5.04% of Java online submissions for Sliding Window Maximum.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k<1 || nums.length<k){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();//存放下标
        int[] result = new int[nums.length-k+1];
        int index=0;
        for(int i=0; i<nums.length; i++){
            while(!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]){//如果对尾的位置不比当前的大，就一直弹出
                qmax.pollLast();
            }
            qmax.addLast(i);//放入当前位置
            if(qmax.peekFirst() == i-k){//如果对头的下标已过期，弹出当前对头
                qmax.pollFirst();
            }
            if(i >= k-1){
                result[index] = nums[qmax.peekFirst()];
                index++;
            }
        }
        return result;
    }
}
