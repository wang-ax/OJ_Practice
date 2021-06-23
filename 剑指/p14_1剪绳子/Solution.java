package p14_1剪绳子;

/**
 * ClassName p14_1剪绳子
 * Description TODO
 * Author 30712
 * Date 2021-06-23
 * Time 17:12
 */
public class Solution {
    public int cuttingRope(int n) {
        /**
         *在一定的约束条件下求最大值，属于最优化的问题，使用动态规划
         * dp[n]表示长度为n的绳子剪断之后，乘积的最大值
         * 状态转移方程：
         * dp[n] = max(dp[j]*dp[n-j])
         *
         * 因为在 n<4 的时候，我们不得不切割，从而乘积变小；
         * 而一旦 n>=4，我们可以选择切割，
         * 也可以选择不切割，当不切割的时候带来的乘积收益大，
         * 我们当然选择不切割，也就是 dp[2]=2 , dp[3]=3 的意思。
         */
/*        if ( n  < 2){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int tempMax =0;
        for (int i=4;i<=n;i++){
            for (int j=1;j<=i/2;j++){
                tempMax = Math.max(dp[j]*dp[i-j],tempMax);
            }
            dp[i] = tempMax;
            tempMax =0;//每次更新
        }
        return dp[n];*/

        /**
         * 数学法
         * n > 4之后，最大的乘积都是2和3的组合
         * 1.有3尽量分3
         * 2.如果分为3后没有余数，刚刚好
         * 3.如果分完3之后，余1，就拿出一个3和余的1组成两个2
         * 4.如果分完3之后余2，就乘2
         */
/*        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        if (n ==4){
            return 4;
        }
        int size = n/3;
        int left = n- size*3;
        if (left == 2){
            return (int)Math.pow(3,size)*2;
        }else if (left == 0){
            return (int)Math.pow(3,size);
        }else {
            return (int)Math.pow(3,size-1)*4;
        }*/
        /**
         * 更简便
         */
        if (n < 2){
            return -1;
        }
        if (n < 4){
            return n-1;
        }
        if (n ==4){
            return 4;
        }
        int ans =1;
        while (n > 4){
            ans*=3;
            n-=3;
        }
        return n*ans;

    }
}
