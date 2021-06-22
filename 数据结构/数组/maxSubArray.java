package p_0622;

/**
 * ClassName p_0622
 * Description TODO
 * Author 30712
 * Date 2021-06-22
 * Time 21:13
 */
public class maxSubArray {
    /**
     * 最大子序列的和，动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        int ans =nums[0];
        int sum =0;
        /**
         * 如果sum>0,说明对于结果有增加的作用，就保留sum再加上当前遍历的数字
         * 如果sum<0 ,说明对于最终的结果没有作用，所以就需要将sum舍弃，sum直接更新为当前遍历的数字
         */
        for (int num: nums){
            if (sum > 0){
                sum+=num;
            }else {
                sum = num;
            }
            //每次比较sum和ans的大小，将最大值置为ans
            ans = Math.max(ans,sum);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray maxSubArray = new maxSubArray();
        maxSubArray.maxSubArray(nums);
    }
}
