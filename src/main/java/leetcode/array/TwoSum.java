package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode.com/problems/two-sum/
 *  1. Two Sum
 *  Easy
 *
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Runtime: 1 ms, faster than 99.98% of Java online submissions for Two Sum.
     * Memory Usage: 39.8 MB, less than 54.99% of Java online submissions for Two Sum.
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        //throw new IllegalArgumentException("No two sum solution");
        return result;

    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            for(int j=i+1; j<nums.length; j++){
                int y = nums[j];
                if(x+y==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;

    }
}
