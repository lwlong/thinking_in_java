package leetcode.array;

/**
 *  https://leetcode.com/problems/rotate-array/
 *  189. Rotate Array
 */
public class RotateArray {
    public static void main(String[] args) {

//        int[] nums = {1,2,3,4,5,6,7};
        int[] nums = {1,2};
        for(int tmp:nums){
            System.out.print(tmp+" ");
        }
        System.out.println();
        rotate(nums,3);
        for(int tmp:nums){
            System.out.print(tmp+" ");
        }
    }

    public static void rotate(int[] nums, int k) {
        if(nums==null || k<0){
            return;
        }
        if(k>nums.length){
            k = k%nums.length;
        }
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);


    }

    public static void reverse(int[] nums, int start, int end){
        int tmp = 0;
        while(start<end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
