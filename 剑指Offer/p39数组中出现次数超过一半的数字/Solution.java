package p39数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName p39数组中出现次数超过一半的数字
 * Description TODO
 * Author 30712
 * Date 2021-06-05
 * Time 17:14
 */
class Solution {
    public int majorityElement(int[] nums) {
        //数字出现的次数超过数组长度的一半
        /**
         排序取出中位数就是超过数组长度一半的数字
         */
        // Arrays.sort(nums);
        // int n = nums.length;
        // return nums[n/2];

        /**
         HashMap:
         key----->数字
         value----->出现的次数
         */
        Map<Integer,Integer> ant = new HashMap<>();
        for(int num : nums){
            ant.put(num, ant.getOrDefault(num, 0) + 1);
            if(ant.get(num) > nums.length / 2){
                return num;
            }
        }
        return 0;
    }
}
