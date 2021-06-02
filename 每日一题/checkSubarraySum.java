package p_0602;

/**
 * ClassName p_0602
 * Description TODO
 * Author 30712
 * Date 2021-06-02
 * Time 20:22
 */

import java.util.HashMap;

/**
 * 同余定理：
 * 当两个数除以某个数的余数相等，那么二者相减后肯定可以被该数整除
 */
public class checkSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if(m < 2){
            return false;
        }
        //子数组的和是k的倍数
        int[] sum = new int[nums.length+1];
        for (int i =1;i< sum.length;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        //只需要计算每个下标对应的前缀和除以 k 的余数即可
        // 使用哈希表存储每个余数第一次出现的下标。
        HashMap<Integer, Integer> mod = new HashMap();  // 保存余数对应的下标
        for (int i=0; i<sum.length; ++i){
            int sumMod = sum[i]%k;

            if (mod.containsKey(sumMod) && i>mod.get(sumMod)+1) {//子数组的大小至少为2
                return true;
            }
            else if (!mod.containsKey(sumMod)){ //只在不存在key时更新，保证子数组长度尽可能大。
                mod.put(sumMod, i);
            }
        }
        return false;
        /*for (int i = 1; i < sum.length; i++) {
            if (sum[i] % k == 0) {
                return true;
            }
            for (int j = 0; j < i - 1; j++) {//子数组的至少为2
                if ((sum[i] - sum[j]) % k == 0) {
                    return true;
                }
            }
        }
        return false;*/
    }
    public static void main(String[] args) {
    //计算前缀和
//        int[] nums = {23,2,4,6,7};
//        int k =6;
//        System.out.println(checkSubarraySum(nums, k));
        int[] nums = {1,2,3,4};
        int[] sum = new int[nums.length+1];
        for (int i =1;i< sum.length;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        for (int num : sum){
         System.out.println(num);
        }

    }
}
