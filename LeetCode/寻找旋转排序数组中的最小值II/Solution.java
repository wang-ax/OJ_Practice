package 寻找旋转排序数组中的最小值II;

/**
 * ClassName 寻找旋转排序数组中的最小值
 * Description TODO
 * Author 30712
 * Date 2021-04-08
 * Time 22:27
 */
public class Solution {
    public int findMin(int[] nums){
        //将原来的数组旋转后是nums
        //在nums中找出nums中的最小元素
        //采用二分查找进行查找
        int low =0;
        int high = nums.length-1;
        while (low < high){
            int mid = low+(high-low)/2;

            if (nums[mid] > nums[high]){
                low = mid+1;
            }else if (nums[mid] < nums[high]){
                high = mid;
            }else {
                high = high-1;
            }
        }
        return nums[low];
    }
}
