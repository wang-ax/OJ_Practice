package p06.p_0610.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName p06.p_0610.两数之和
 * Description TODO
 * Author 30712
 * Date 2021-06-10
 * Time 21:38
 */
public class Solution {
    public static int[] twoSum (int[] numbers,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            if (map.get(target-numbers[i]) != null){
                return new int[]{map.get(target - numbers[i])+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {3,2,4};
        int target = 6;
        int[] twoSum = twoSum(numbers, target);
        for (int s : twoSum){
            System.out.println(s);
        }
    }
}
