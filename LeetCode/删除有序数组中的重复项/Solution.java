class Solution {
    public int removeDuplicates(int[] nums) {
        //删除有序数组中的重复项
        //双指针
        int n = nums.length;
        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[slow - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}