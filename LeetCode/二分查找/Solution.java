package p08.p_0815.二分查找;

/**
 * ClassName p08.p_0815.二分查找
 * Description TODO
 * Author 30712
 * Date 2021-08-15
 * Time 23:41
 */
public class Solution {
    public int search (int[] nums,int target){
        //二分查找
        int i= 0;
        int j = nums.length-1;
        while (i <= j){
            int mid = (i+j)/2;
            if (nums[mid] > target){
                j = mid-1;
            }else if(nums[mid] < target){
                i = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        Solution s = new Solution();
        System.out.println(s.search(nums,5));
    }
}
