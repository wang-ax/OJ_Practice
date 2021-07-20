package p07.p_0720.数组中最大数对的最小值;

import java.util.Arrays;

/**
 * ClassName p07.p_0720.数组中最大数对的最小值
 * Description TODO
 * Author 30712
 * Date 2021-07-20
 * Time 15:06
 */
public class Solution {
    public int minPairSum(int[] nums) {
        //最大数对和的最小值
        int n = nums.length;
        //排序
        Arrays.sort(nums);
     /*   for (int i=0;i < n ;++i){
            res = Math.max(res,nums[i]+nums[n-1-i]);
        }*/
        int res = nums[0] + nums[n-1];
        for (int i=0 ,j = n-1 ;i < j ;i++,j--){
            res = Math.max(res,nums[i]+nums[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,5,4,2,4,6};
        System.out.println(solution.minPairSum(nums));
    }
}
