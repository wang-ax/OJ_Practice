package p_0603;

import java.util.HashMap;

/**
 * ClassName p_0603
 * Description TODO
 * Author 30712
 * Date 2021-06-03
 * Time 16:30
 */
public class findMaxLength {
    public static int findMaxLength(int[] nums){
        int len = nums.length;
        //用于记录最长的子数组
        int max = Integer.MIN_VALUE;
        //将nums中所有0元素换成-1,如果子数组中有相同数量的0和1，那么前缀和就是0
        for(int i = 0; i < len; i++)
            nums[i] = nums[i] == 0 ? -1 : nums[i];
        /**
         * sum[i]表示的以元素nums[i]为结尾的前缀和，只需要在sum中找到
         * sum[i]=0 或者sum[i] = sum[j]的解
         * sum[i]=0表示从下标0-i构成的数组是符合条件的
         * sum[i] = sum[j] ：下标i+1 ——j 构成的子数组是符合条件的
         *
         * */
        //前缀和
        int sum = 0;
        //map
        /**
         * HashMap<Integer,Integer>  key:前缀和，value：结尾的下标
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        //提前put一个<0, -1>以防止前缀和等于0的情况被忽略
        map.put(0, -1);
        //对一个前缀和 sum[i] 如果 map 中存在该前缀和，
        //那么该子数组的长度为 i - map.get(sum[i]); 反之将 sum put进map
        for(int i = 0; i < len; i++)
        {
            sum += nums[i];
            if(map.containsKey(sum))
            {
                int index = map.get(sum);
                max = Math.max(max, i - index);
            }
            else
                map.put(sum, i);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
