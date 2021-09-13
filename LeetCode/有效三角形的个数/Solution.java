package p08.p_0804.有效三角形的个数;

import java.util.Arrays;


public class Solution {
    public int triangleNumber(int[] nums) {
        //统计可以组成三角形三条边的三元组的个数
        //任意两边之和大于第三边,任意两边之差小于第三边

        //对数组进行排序
        Arrays.sort(nums);
        //固定最短的两条边，二分查找最后一个小于两边之和的位置。
        // 可以求得固定两条边长之和满足条件的结果。
        // 枚举结束后，总和就是答案。
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                int s = nums[i] + nums[j];
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s){
                        l = mid;
                    }
                    else{
                        r = mid - 1;
                    }
                }
                if (nums[r] < s) {
                    res += r - j;
                }
            }
        }
        return res;
    }
}
