package 森林中的兔子;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName 森林中的兔子
 * Description TODO
 * Author 30712
 * Date 2021-04-04
 * Time 22:15
 */
public class Solution {
    public int numRabbits(int[] answers) {
        //兔子的最少数量
        Map<Integer,Integer> count = new HashMap<>();
        //哈希表统计answers中各个元素的出现次数
        for (int y : answers){
            count.put(y,count.getOrDefault(y,0)+1);
        }
        int result =0;
        //如果有x只兔子都回答y，至少有x/（y+1）种不同的颜色，且每种颜色有y+1只兔子
        //所以兔子的数量至少为[x/(y+1)]*(y+1)
        for (Map.Entry<Integer,Integer> entry : count.entrySet()){
            int y = entry.getKey();
            int x = entry.getValue();

            result += (x+y)/(y+1)*(y+1);
        }
        return result;
    }
}
