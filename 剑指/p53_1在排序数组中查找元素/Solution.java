package p53_1在排序数组中查找元素;

/**
 * ClassName p53_1在排序数组中查找元素
 * Description TODO
 * Author 30712
 * Date 2021-06-07
 * Time 21:16
 */

/**
 * 排序数组，首先想到的就是使用二分查找进行查找
 */
public class Solution {
    public int search(int[] nums, int target) {
        // int count=0;
        // //统计一个数字在排序数组中出现的次数
        // for(int i =0;i<nums.length;i++){
        //     if(nums[i]== target){
        //         count++;
        //     }
        // }
        // return count;

        //二分查找
        //二分查找的时间明显要快于遍历的时间
        int count=0;
        int left =0;
        int right = nums.length-1;
        while(left < right){
            int mid = (right+left)/2;
            if(nums[mid] >= target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }
        }
        while(left < nums.length && nums[left] == target){
            left++;
            count++;
        }
        return count;
    }
}
