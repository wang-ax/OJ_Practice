package p07.p_0702;

import java.util.Arrays;

/**
 * ClassName p07.p_0702
 * Description TODO
 * Author 30712
 * Date 2021-07-02
 * Time 10:02
 */
public class maxIceCream {
    /**
     * 排序+ 贪心
     * 题目要求一定数额的钱，要获得最多数量的雪糕
     * 先买最便宜的，然后再买次便宜的.......
     * 先将数组排序，排序后从头开始遍历，一直算到前i个雪糕价钱之和大于coin停止（或者一直小于coin就遍历到数组尾部停止）
     * @param costs  雪糕的价格
     * @param coins 现金量
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        int n = costs.length;
        for (int i=0;i< n;i++){
            int cost = costs[i];
            if (coins >= cost){
                coins -=cost;
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
