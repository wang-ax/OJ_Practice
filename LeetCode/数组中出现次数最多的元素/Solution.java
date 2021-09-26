package p09.p_0910.数组中出现次数最多的元素;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName p09.p_0910
 * Description TODO 找出数组中出现次数最多的元素
 * Author 30712
 * Date 2021-09-10
 * Time 23:24
 */
public class Solution {
    public  static int maxNum (int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        int maxCount = 0 ;
        for (int value : map.values()){
            if (value > maxCount){
                maxCount = value;
            }
        }
        int maxnum =0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (maxCount == entry.getValue()){
                maxnum = entry.getValue();
            }
        }
        return maxnum;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,4,6};
        System.out.println(maxNum(array));
    }
}
