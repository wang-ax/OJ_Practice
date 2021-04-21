package 和为K的子数组;

/**
 * ClassName 和为K的子数组
 * Description TODO
 * Author 30712
 * Date 2021-04-21
 * Time 9:36
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
       /* int count =0;
        for(int i =0 ;i<nums.length;i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int m = i; m <= j; m++) {
                    sum += nums[m];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;*/

        //暴力解法
        //固定了左边的边界，然后枚举右边的值，时间复杂度是O(n^2)
        int count =0;
        for(int i =0 ;i<nums.length;i++){
            int sum =0;
            for(int j =i;j <nums.length;j++){
                sum +=nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;

        //前缀和
        


    }

}
