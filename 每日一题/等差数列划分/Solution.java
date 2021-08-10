package p08.p_0810.等差数列划分;

/**
 * ClassName p08.p_0810.等差数列划分
 * Description TODO  给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 子数组 是数组中的一个连续序列。
 * https://leetcode-cn.com/problems/arithmetic-slices/
 * Author 30712
 * Date 2021-08-10
 * Time 9:53
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //所有为等差数列的子数组
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        //子数组
        int ans =0;

        int start =0;
        int next=1;
        for (int i=0;i<nums.length-2;i=start){
            while (i < nums.length-2 && 2*nums[i+1] == nums[i+2]+nums[i]){
                i++;
                ans +=next;
                next++;
            }
            start = i+1;
            next =1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s  = new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(s.numberOfArithmeticSlices(nums));
    }
}
