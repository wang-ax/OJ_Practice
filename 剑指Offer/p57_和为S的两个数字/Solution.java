package p57_和为S的两个数字;

/**
 * ClassName 和为S的两个数字
 * Description TODO
 * Author 30712
 * Date 2021-06-01
 * Time 16:34
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //双指针
        int[] result = new int[2];
        int i =0;
        int j = nums.length-1;
        while(i < j){
            int s = nums[i]+nums[j];
            if(s > target){
                j--;
            }else if(s < target){
                i++;
            }else{
                result[0] = nums[i];
                result[1] = nums[j];
                return  result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution solution  = new Solution();
        int[] sum = solution.twoSum(nums, target);
        for (int s :sum){
            System.out.println(s);
        }
    }
}
