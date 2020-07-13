package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 *  https://leetcode.com/problems/longest-consecutive-sequence/
 *  128. Longest Consecutive Sequence
 *
 *  代码面试指南 P248 数组中的最长连续序列（动态规划？）
 *  利用HashMap记录之前的数是否出现过，和前后的最长距离
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums));//4    [1, 2, 3, 4]
    }

    /**
     * Runtime: 5 ms, faster than 57.48% of Java online submissions for Longest Consecutive Sequence.
     * Memory Usage: 39.8 MB, less than 60.64% of Java online submissions for Longest Consecutive Sequence.
     */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
                if(map.containsKey(nums[i]-1)){
                    max = Math.max(max,merge(map, nums[i]-1, nums[i]));
                }
                if(map.containsKey(nums[i]+1)){
                    max = Math.max(max,merge(map, nums[i], nums[i]+1));
                }
            }
        }
        return max;
    }

    public int merge(HashMap<Integer,Integer> map, int less, int more){
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }


}
