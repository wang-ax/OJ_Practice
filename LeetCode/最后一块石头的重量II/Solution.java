package p_0608.最后一块石头的重量II;

/**
 * ClassName p_0608.最后一块石头的重量II
 * Description TODO
 * Author 30712
 * Date 2021-06-08
 * Time 15:45
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        //从stones任意选择两个石头
        /**
         * 将n块石头分为两堆，而后求两堆石头重量总和的最小差值
         * 01背包问题：背包的容量为这n块石头总重量的一半
         * 理想情况下，如果可以刚好装满背包，两队石头重量总和的最小差值可为0
         */
        //dp[i][j] 表示当可选的石头为前i个，容量为j的背包所能存放的实际最大值
        int n = stones.length;
        int sum =0;
        for (int stone : stones){
            sum += stone;
        }
        int m = sum/2;
        //背包的容量上限为石头总重量的一半
        int[][] dp = new int[n+1][m+1];
        for (int i=1;i <=n;i++){
            for (int j =0;j<=m;j++){
                //这块石头不放进背包
                dp[i][j] = dp[i-1][j];
                if (j >=stones[i-1]){
                    //当能把这块是否放进背包里时，选择最大值
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
                }
            }
        }
        //dp[n][sum/2]的最大值为sum/2,最理想的结果是0
        return Math.abs(sum-dp[n][m]-dp[n][m]);

        /**
         * 一维
         */
//         int cap = sum/2;
//        //背包容量上限为石头总重量的一半
//        int dp[] = new int[cap+1];
//        for(int i=0;i<n;i++){
//            //内层倒序遍历
//            for(int j=cap;j>=stones[i];j--){
//                dp[j] = Math.max(dp[j],dp[j-stones[i]] + stones[i]);
//            }
//        }
//        return sum-dp[cap]*2;


    }
}
