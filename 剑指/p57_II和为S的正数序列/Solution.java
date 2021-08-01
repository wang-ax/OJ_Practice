package p57_II和为S的正数序列;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName p57_II和为S的正数序列
 * Description TODO
 * Author 30712
 * Date 2021-06-10
 * Time 20:22
 */
class Solution {
    /**
     * 当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
     * 当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
     * 当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)，
     * 那么我们已经找到了一个 i 开头的序列，也是唯一一个 i 开头的序列，接下来需要找 i+1 开头的序列，所以窗口的左边界要向右移动
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        //滑动窗口
        int left =1;//滑动窗口的左边界
        int right =1;//滑动窗口的右边界
        List<int[]> res = new ArrayList<>();
        int sum=0;//滑动窗口中数字的和
        while(left <= target/2){
            if(sum  < target){
                //右边界向右移动
                sum += right;
                right++;
            }else if(sum > target){
                //左边界向右移动
                sum -=left;
                left++;
            }else{
                //记录结果
                int[] arr = new int[right-left];
                for(int k = left; k < right ;k++){
                    arr[k-left] =k;
                }
                res.add(arr);
                //左边界向右移动
                sum -=left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
