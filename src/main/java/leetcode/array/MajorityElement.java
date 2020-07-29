package leetcode.array;

/**
 *  https://leetcode.com/problems/majority-element/
 *  169. Majority Element 多数元素
 *  Easy
 *
 *  代码面试指南 P372 在数组中找到出现次数大于N/K的数
 *  一次删掉k个不同的数的思想，例如：投票候选人得票数需要过半数
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));//2
    }

    /**
     * Runtime: 3 ms, faster than 62.60% of Java online submissions for Majority Element.
     * Memory Usage: 50.9 MB, less than 5.14% of Java online submissions for Majority Element.
     */
    public static int majorityElement(int[] nums) {
        int cand = 0;
        int times = 0;
        for(int i=0; i<nums.length; i++){
            if(times==0){
                cand = nums[i];
                times = 1;
            }else if(nums[i]==cand){
                times++;
            }else{
                times--;
            }
        }
        times=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==cand){
                times++;
            }
        }
        if(times>nums.length/2){
            return cand;
        }
        return -1;
    }
}
