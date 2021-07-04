package p07.p_0704.错误的集合;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ClassName p07.p_0704.错误的集合
 * Description TODO
 * Author 30712
 * Date 2021-07-04
 * Time 14:12
 */
public class Solution {
    public  static int[] findErrorNums(int[] nums) {
        //找到重复的数字和丢失的数字
        /**
         * 数组排序之后，比较相邻的元素
         * 如果相邻的两个元素相等，该元素即为重复的数字
         * 寻找丢失的数字可能有以下两种情况：
         * 1.如果丢失的数字大于 1且小于 n，
         * 则一定存在相邻的两个元素的差等于 2，这两个元素之间的值即为丢失的数字；
         * 2.如果丢失的数字是 1 或 n，则需要另外判断
         */
        Arrays.sort(nums);
        int[] errorNums = new int[2];
        int prev =0;//有可能丢失的数字是1，将prev初始化为0
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            if (current == prev){
                errorNums[0] = prev;
            }else if (current - prev > 1){
                errorNums[1] = prev+1;
            }
            prev = current;
        }
        //丢失的数字是最后一个数字
        if (nums[nums.length-1] != nums.length){
            errorNums[1] = nums.length;
        }
        return errorNums;
    }
    public  static int[] findErrorNums2(int[] nums){
        int[] errorNum = new int[2];
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        //遍历数组填入哈希表
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //遍历1-n的每个数寻找错误的集合
        for (int i=1;i<=n;i++){
            int count = map.getOrDefault(i,0);
            if (count == 2){
                //重复的数字，出现的次数是2
                errorNum[0] = i;
            }else if(count == 0){
                //丢失的数字出现的次数是0
                errorNum[1]=i;
            }
        }
        return errorNum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        int[] errorNums = findErrorNums2(nums);
        for (int error : errorNums){
            System.out.println(error);
        }
    }
}
