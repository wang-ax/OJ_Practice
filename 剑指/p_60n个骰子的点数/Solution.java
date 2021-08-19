package p_60n个骰子的点数;

import java.util.Arrays;

/**
 * ClassName p_60n个骰子的点数
 * Description TODO
 * Author 30712
 * Date 2021-08-19
 * Time 17:43
 */
public class Solution {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);
        for (int i=2;i<=n;i++){
            double[] tmp = new double[5*i+1];
            for (int j =0;j< dp.length;j++){
                for (int k=0;k < 6;k++){
                    tmp[j+k] +=dp[j]/6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
