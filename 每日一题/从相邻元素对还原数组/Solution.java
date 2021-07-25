package p07.p_0725.从相邻元素对还原数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName p07.p_0725.从相邻元素对还原数组
 * Description TODO
 * Author 30712
 * Date 2021-07-25
 * Time 10:13
 */
public class Solution {
    /**
     * 如果是数组的第一个或最后一个元素，该元素就有且仅有一个元素与其相邻
     * 如果是中间的元素，则该元素有且仅有两个元素与其相邻
     * @param adjacentPairs
     * @return
     */
    public  static int[] restoreArray(int[][] adjacentPairs) {
        //使用哈希表记录每一个元素的相邻的元素有哪些
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs){
            /**
             * put在放入数据时，如果放入数据的key已经存在与Map中，最后放入的数据会覆盖之前存在的数据
             * putIfAbsent 再放入数据时，如果存在重复的key，那么putIfAbsent不会放入值
             * putIfAbsent 如果传入key对应的value已经存在，就返回存在的value，不进行替换。
             *              如果不存在，就添加key和value，返回null
             */
            map.putIfAbsent(adjacentPair[0],new ArrayList<>());
            map.putIfAbsent(adjacentPair[1],new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        //最终得到的数组是二维数组的长度加1
        int n = adjacentPairs.length+1;
        int[] ret = new int[n];

        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            //如果只有一个相邻的元素，那么就是ret的第一个元素或者最后一个元素
            if (adj.size() == 1){
                ret[0] =e;
                break;
            }
        }
        //先得到ret[1]——ret[0]唯一的相邻的元素就是ret[1]
        ret[1] = map.get(ret[0]).get(0);

        for (int i=2;i<n;i++){
            //要得到ret[2]的内容，先要通过ret[1]得到ret[1]的相邻元素
            List<Integer> adj = map.get(ret[i-1]);
            //由于处于中间位置的元组相邻的元素有且只有两个元素
            //所以需要判断ret[0]的元素是ret[1]相邻元素的list中的哪个元素剩下的那个元素就是ret[2]的元素
            if(ret[i-2] == adj.get(0)){
                ret[i] = adj.get(1);
            }else {
                ret[i] = adj.get(0);
            }
            // ret[i] = ret[i-2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] num = {{2,1},{3,4},{3,2}};
        int[] array = restoreArray(num);
        for (int a : array){
            System.out.println(a);
        }
    }
}
