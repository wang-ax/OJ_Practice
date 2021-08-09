package p08.p_0809.超级丑数;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * ClassName p08.p_0809.超级丑数
 * Description TODO
 * Author 30712
 * Date 2021-08-09
 * Time 16:47
 */
public class Solution {
    //最小堆
    public int nthSuperUglyNumber(int n,int[] primes){
        if (n == 1){
            return 1;
        }
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        //将最小的超级丑数加入堆中
        heap.add(1L);
        int ugly = 0;
        for (int i =0;i< n;i++){
            long current = heap.poll();
            ugly = (int)current;
            for (int prime : primes){
                long  next = current * prime;
                if (set.add(next)){
                    heap.offer(next);
                }
            }
        }
        //第n次从最小堆中取出的元素即为第n个超级丑数
        return ugly;
    }
    //动态规划
    public int nthSuperUglyNumber2(int n,int[] primes){
        //dp[i]表示第i个超级丑数
        int[] dp = new int[n+1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers,1);
        for (int i =2;i<=n;i++){
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j=0;j< m;j++){
                nums[j] = dp[pointers[j]]*primes[j];
                minNum = Math.min(minNum,nums[j]);
            }
            dp[i] = minNum;
            for (int j =0;j< m;j++){
                if (minNum == nums[j]){
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

}
