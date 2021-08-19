package p46_把数字翻译成字符串;

/**
 * ClassName p46_把数字翻译成字符串
 * Description TODO
 * Author 30712
 * Date 2021-08-19
 * Time 17:16
 */
public class Solution {
    /**
     * 动态规划
     * dp[i] 表示以xi为结尾的数字的翻译方案的数量
     * 若 x_i和 x i−1组成的两位数字可以被翻译，则 dp[i] = dp[i - 1] + dp[i - 2]
     * 否则 dp[i] = dp[i - 1]
     */

    public int translateNum(int num) {
        //把数字翻译成字符串，计算一个数字有多少种不同的翻译方法
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0] =1;
        dp[1] = 1;
        for (int i=2;i<= s.length();i++){
            String temp = s.substring(i-2,i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <=0){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
