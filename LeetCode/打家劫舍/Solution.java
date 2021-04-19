package 打家劫舍;

/**
 * ClassName 打家劫舍
 * Description TODO
 * Author 30712
 * Date 2021-04-15
 * Time 21:40
 */
 public class Solution {
    public int rob(int[] nums) {
        //只是不能偷相邻的房间
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }else if(length == 2){
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
