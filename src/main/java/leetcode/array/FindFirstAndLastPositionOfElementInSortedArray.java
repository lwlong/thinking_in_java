package leetcode.array;

import java.util.Arrays;

/**
 *  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *  34. Find First and Last Position of Element in Sorted Array
 *  Array，Binary Search
 *
 *  Input: nums = [5,7,7,8,8,10], target = 8
 *  Output: [3,4]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] result = searchRange(nums, 6);
//        int[] nums = new int[]{2,2};
//        int[] result = searchRange(nums, 2);

        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if(nums==null || nums.length==0){
            return result;
        }
        int left = 0;
        int right = nums.length-1;
        //find first position
        while(left<=right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                if(mid == 0 || nums[mid-1]!=target){
                    result[0] = mid;
                    //return
                    break;
                }else{
                    right = mid-1;
                }
            }
        }
//        //find last position
//        while(left<=right){
//            int mid = left + ((right-left)>>1);
//            if(nums[mid] > target){
//                right = mid-1;
//            }else if(nums[mid] < target){
//                left = mid+1;
//            }else{
//                if(mid == nums.length-1 || nums[mid+1]!=target){
//                    result[1] = mid;
//                    break;
//                }else{
//                    left = mid+1;
//                }
//            }
//        }
        if(result[0] != -1){
            result[1] = result[0];
            right = result[0]+1;
            while(right<=nums.length-1 && nums[right]==target ){
                result[1] = right;
                right++;
            }
        }
        return result;
    }
}
