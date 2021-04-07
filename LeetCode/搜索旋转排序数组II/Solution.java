package 搜索旋转排序数组II;

/**
 * ClassName 搜索旋转排序数组II
 * Description TODO
 * Author 30712
 * Date 2021-04-07
 * Time 23:03
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        //nums非降序排列
        //判断给定的目标值是否存在数组中
        /**
         * 暴力解决
         */
        for(int i =0;i< nums.length;i++){
            if(target == nums[i]){
                return true;
            }
        }
        return false;


    }
}
