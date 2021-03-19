package 数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName 数组中出现次数超过一半的数字
 * Description TODO
 * Author 30712
 * Date 2021-03-19
 * Time 8:28
 */
public class Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        /**
         * 使用HashMap来记录每个数字出现的次数
         */
        HashMap<Integer,Integer> map = new HashMap<>();
        //得到每个数字出现的次数
        for (int x : array){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        //如果出现的次数大于数组的长度，就输出key的值
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            int key = m.getKey();
            int value = m.getValue();
            if (value > array.length/2){
                return key;
            }
        }
        return 0;
        /**
         * 直接使用排序
         */
        /*Arrays.sort(array);
        int count =0;
        for (int i =0;i< array.length;i++){
            if (array[i] == array[array.length/2]){
                count++;
            }
        }
        if (count > array.length/2){
            return array[array.length/2];
        }else {
            return 0;
        }*/
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,3,3,2,2,2,2,5,6};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
