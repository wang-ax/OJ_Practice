package p07.p_0717;

/**
 * ClassName p07.p_0717
 * Description TODO 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * Author 30712
 * Date 2021-07-17
 * Time 8:44
 */
public class maxSubArray {
    /**
     * 动态规划
     * dp[i] 代表以元素nums[i]为结尾的连续子数组的最大和
     * 转移方程
     * dp[i] = dp[i-1]+nums[i] (dp[i-1] > 0)
     * dp[i] = nums[i] (dp[i-1] <=0)
     * 时间复杂度：O(N)——线性遍历数组nums即可获得结果，使用O(N)时间
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        //连续子数组的最大和
        //连续子数组的和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int j =1;j< nums.length;j++){
            if(dp[j-1] > 0){
                dp[j] = dp[j-1]+nums[j];
            }else{
                dp[j] = nums[j];
            }
        }
        int max = dp[0];
        for(int i=0;i< dp.length;i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
