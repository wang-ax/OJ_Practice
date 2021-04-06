package 删除有序数组中的重复项II;

/**
 * ClassName 删除有序数组中的重复项
 * Description TODO
 * Author 30712
 * Date 2021-04-06
 * Time 12:39
 */
public class Solution {
    //返回的数值是整数，但输出的答案是数组
    //输入数组是以引用的方式传递的，在函数里修改输入数组对于调用者是可见的
    public int removeDuplicates(int[] nums) {
        //删除重复出现的元素，每个元素最多出现两次
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
