package p45把数组排成最小的数;

/**
 * ClassName p45把数组排成最小的数
 * Description TODO
 * Author 30712
 * Date 2021-08-18
 * Time 23:34
 */
public class Solution {
    public String minNumber(int[] nums){
        StringBuilder result = new StringBuilder();
        String[] strings = new String[nums.length];
        for (int i=0;i< nums.length;i++){
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings,0,strings.length-1);
        for (String s : strings){
            result.append(s);
        }
        return result.toString();
    }
    //快速排序
    /**
     *排序的规则是 若x+y > y+x 则 x > y 即x排在y的后面
     *          否则 x < y
     */

    public void  quickSort(String[] strs ,int left,int right){
        if (left >= right){
            return;
        }
        int i = left;
        int j = right;

        String temp = strs[i];

        while(i < j) {
            while((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && i < j){
                j--;
            }
            while((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && i < j){
                i++;
            }

            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        strs[i] = strs[left];
        strs[left] = temp;
        //分别对两边进行排序
        quickSort(strs,left,i-1);

        quickSort(strs,i+1,right);
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Solution s = new Solution();
        System.out.println(s.minNumber(nums));
    }
}
