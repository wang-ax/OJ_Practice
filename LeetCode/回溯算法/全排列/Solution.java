package p_0607.回溯算法.全排列;


import java.util.LinkedList;
import java.util.List;

/**
 * ClassName p_0607.回溯算法.全排列
 * Description TODO
 * Author 30712
 * Date 2021-06-07
 * Time 16:53
 */
public class Solution {
    //存储所有全排列的结果
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        //记录递归的路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);//递归的次数：n!
        return result;
    }

    /**
     * 回溯算法框架
     * @param nums
     * @param track
     */
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //到达叶子节点，将路径装入结果列表中
        if (track.size() == nums.length){
            result.add(new LinkedList<>(track));
            return;
        }
        //整个for循环的时间复杂度是O(n^2)
        for (int i =0;i<nums.length;i++){
            //排除不合法的选择
            if (track.contains(nums[i])){//时间复杂度是O(n)
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums,track);
            //取消选择
            track.removeLast();
        }
    }
}
