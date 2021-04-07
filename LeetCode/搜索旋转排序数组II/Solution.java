package 搜索旋转排序数组II;

/**
 * ClassName 搜索旋转排序数组II
 * Description TODO
 * Author 30712
 * Date 2021-04-07
 * Time 23:03
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        //nums非降序排列
        //判断给定的目标值是否存在数组中
        /**
         * 暴力解决
         */
       /* for(int i =0;i< nums.length;i++){
            if(target == nums[i]){
                return true;
            }
        }
        return false;*/

        /**
         * 二分查找
         */
        int n = nums.length;
        if (n == 0){
            return  false;
        }
        if (n == 1){
            return nums[0] == target;
        }
        int left = 0;
        int right = n-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid]){
                if (nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else {
                    right = mid+1;
                }
            }else {
                if (nums[mid] < target && target <= nums[n-1]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return  false;
    }
}
