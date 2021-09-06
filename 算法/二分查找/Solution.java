package p09.p_0906.二分查找;

/**
 * ClassName p09.p_0906
 * Description TODO
 * Author 30712
 * Date 2021-09-06
 * Time 14:26
 */
public class Solution {
    /**
     * 二分查找
     * 如果目标值不存在于数组中，返回-1即可
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while(i <=j){
            int mid = (i+j)/2;
            if (target < nums[mid]){
                j = mid -1;
            }else if(target > nums[mid]){
                i = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    /**
     * 搜索插入位置
     * 如果目标值不存在于数组中，返回它将被顺序插入的位置
     * 时间复杂度必须是O(log(n))——必须使用二分查找完成
     */
    public int searchInsert(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(target < nums[mid]){
                right = mid-1;
            }else if(target > nums[mid]){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
