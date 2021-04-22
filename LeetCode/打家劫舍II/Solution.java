package 打家劫舍II;

/**
 * ClassName 打家劫舍II
 * Description TODO
 * Author 30712
 * Date 2021-04-15
 * Time 21:14
 */
public class Solution {
    //不能偷相邻的房间，而且首尾是相连的
    public int rob(int[] nums){
        int length = nums.length;
        if (length == 1){
            return nums[0];//只有一家，就只能偷这一家
        }else if (length == 2){
            return Math.max(nums[0],nums[1]);//只有两家，只能偷其中金额最大的
        }
        return Math.max(robRange(nums,0,length-2),robRange(nums,1,length-1));
    }

    private int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start],nums[end]);
        for (int i = start+2;i<=end;i++){
            int temp = second;
            second = Math.max(first+nums[i],second);
            first = temp;
        }
        return second;
    }
}
