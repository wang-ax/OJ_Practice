package p_0607.目标和;

/**
 * ClassName p_0607.目标和
 * Description TODO
 * Author 30712
 * Date 2021-06-07
 * Time 19:50
 */
class Solution {
     static int count = 0;

    public static int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public static void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findTargetSumWays(nums,1));
    }
}

