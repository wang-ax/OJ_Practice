package p07.p_0708.和相同的二元子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName p07.p_0708.和相同的二元子数组
 * Description TODO
 * Author 30712
 * Date 2021-07-08
 * Time 10:43
 */
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        /**
         * 暴力解法
         * 时间复杂度：O(N^2)，双重遍历数组
         */
/*        int count =0;
       //int sum =0;
        for(int i=0;i<nums.length;i++){
            int sum =nums[i];
            if (sum == goal){
                count++;
            }else if(sum > goal){
                continue;
            }
            for (int j =i+1;j< nums.length;j++){
                sum += nums[j];
                if (sum == goal){
                    count++;
                }else if (sum > goal){
                    break;
                }
            }
        }
        return count;*/
        /**
         * 前缀和+哈希表
         * 前缀和数组sum
         *用哈希表记录每一种前缀和出现的次数
         * 当枚举到nums[j] ,只需要查询哈希表中元素sum[j] - goal的数量
         * 时间复杂度度:O(N)
         */
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        Solution s = new Solution();
        System.out.println(s.numSubarraysWithSum(nums, goal));
    }
}
