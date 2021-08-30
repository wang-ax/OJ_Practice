package p08.p_0830.按权重随机选择;

import java.util.Arrays;

/**
 * ClassName p08.p_0830.按权重随机选择
 * Description TODO
 * Author 30712
 * Date 2021-08-30
 * Time 10:36
 */
public class Solution {
    int[] pre;
    int total;

    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i=1;i< w.length;i++){
            pre[i] = pre[i-1] +w[i];
        }
        total = Arrays.stream(w).sum();
    }
    public int pickIndex(){
        int x = (int)(Math.random()*total)+1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int low =0;
        int high = pre.length-1;
        while (low < high){
            int mid = (high-low)/2+low;
            if (pre[mid] < x){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
