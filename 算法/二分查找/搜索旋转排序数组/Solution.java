package p09.p_0906.二分查找.搜索旋转排序数组;

/**
 * ClassName p09.p_0906.二分查找.搜索旋转排序数组
 * Description TODO
 * Author 30712
 * Date 2021-09-06
 * Time 15:27
 */
public class Solution {
    /**
     *
     * @param nums 旋转后的数组
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //数组如果是有序的，直接使用二分查找完成
        /**
         * 暴力解法
         * 遍历整个数组，时间复杂度是O(n)，空间复杂度是O(1)
         */
       /* for (int i=0;i<nums.length;i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;*/

        int n = nums.length;
        if (n == 0){
            return -1;
        }
        if (n == 1 ){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[0] < nums[mid]){
                //证明左边是有序的
                if (nums[0] <= target && target < nums[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (nums[mid] < target && target <= nums[n-1]){
                    left = mid+1;
                }else {
                    right = mid +1;
                }
            }
        }
        return -1;
    }
}
