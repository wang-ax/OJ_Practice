package 子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName 子集II
 * Description TODO
 * Author 30712
 * Date 2021-03-31
 * Time 22:12
 */
public class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //返回所有可能的子集
        //回溯
        List<List<Integer>> list = new ArrayList<>();//最终返回的集合
        List<Integer> temp = new ArrayList<>();
        list.add(temp);
        if(nums == null || nums.length == 0){
            return list;
        }
        Arrays.sort(nums);
        backtracking(nums,0,temp,list);
        return list;
    }

    private static void backtracking(int[] nums, int start, List<Integer> temp, List<List<Integer>> list) {
        for (int  i = start;i < nums.length;i++){
            temp.add(nums[i]);
            backtracking(nums,i+1,temp,list);
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            while (i+1 < nums.length && nums[i] == nums[i+1]){
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));

    }
}
