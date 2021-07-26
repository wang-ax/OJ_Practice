package p07.p_0726.得到子序列的最少操作次数;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName p07.p_0726.得到子序列的最少操作次数
 * Description TODO
 * Author 30712
 * Date 2021-07-26
 * Time 9:33
 */
class Solution {
    /**
     * 贪心+二分查找
     * @param target
     * @param arr
     * @return
     */
    public static int minOperations(int[] target, int[] arr) {
        //要添加的元素是target有的元素，但是arr中没有的元素，要向arr中插入元素
        //返回最少的操作次数，使得target成为arr的一个子序列
        int n = target.length;
        //int m = arr.length;
        //最少添加的元素个数为n减去两组的最长公共子序列的长度
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(target[i],i);
        }
        List<Integer> d = new ArrayList<>();
        for (int val : arr){
            if (map.containsKey(val)){
                int index = map.get(val);
                int it = binarySearch(d,index);
                if (it != d.size()){
                    d.set(it,index);
                }else {
                    d.add(index);
                }
            }
        }
        return n-d.size();
    }

    //二分查找
    private static int binarySearch(List<Integer> d, int target) {
        int size = d.size();
        if (size == 0 || d.get(size-1) < target){
            return size;
        }
        int low =0;
        int high = size-1;
        while (low < high){
            int mid = (high-low)/2+low;
            if (d.get(mid) < target){
                low = mid +1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] target = {6,4,8,1,3,2};
        int[] arr = {4,7,6,2,3,8,6,1};
        System.out.println(minOperations(target, arr));

    }
}
