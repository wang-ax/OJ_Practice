package 丑数II;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * ClassName 丑数II
 * Description TODO
 * Author 30712
 * Date 2021-04-11
 * Time 21:11
 */
public class Solution {
    /**
     * 最小堆
     * 初始化时堆为空，首先将最小的丑数1加入堆中
     * 每次取出堆顶的元素x，是堆中最小的丑数；
     * 由于 2x, 3x, 5x也是丑数，因此将 2x, 3x, 5x 加入堆
     * 按照上面的方法会出现重复的数字，所以在加入堆之前进行去重HashSet
     * 排除了重复的元素之后，第n次从堆中取出来的元素就是第n个丑数
     * @param n
     * @return
     */
    public int nthUglyNumber(int n ){
        int [] factors = {2,3,5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        //最小的丑数是1，先将1加入最下堆中
        heap.offer(1L);
        int ugly =0;
        for (int i =0;i<n;i++){
            long current = heap.poll();
            ugly = (int) current;
            for (int factor :factors){
                long next = current*factor;
                if (seen.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    /**
     * 动态规划，三个指针完成
     * 生成第n个丑数
     * 要从第一个丑数开始逐渐的向后寻找。
     * 丑数只包含2，3，5三个因子，所以生成的方式就是在已经生成的丑数中乘以【2，3，5】得到新的丑数
     * 用还没有乘过2的最小丑数乘以2
     * 用还没有乘过3的最小丑数乘以3
     * 用还没有乘过5的最小丑数乘以5
     * 在得到的数字中取最小的数字，就是新的丑数
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n){
        if(n < 0){
            return 0;
        }
        //dp[i]表示第i个丑数
        int dp[] = new int[n+1];
        dp[1] =1;
        //三个指针
        int p2=1,p3 =1,p5 =1;
        for (int i=2;i<=n;i++){
            int num2 = dp[p2]*2;
            int num3 = dp[p3]*3;
            int num5 = dp[p5]*5;
            dp[i] = Math.min(Math.min(num2,num3),num5);
            if (dp[i] == num2){
                p2++;
            }
            if (dp[i] == num3){
                p3++;
            }
            if (dp[i] == num5){
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(5));
    }
}
