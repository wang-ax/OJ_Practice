package p08.p_0803.最短无序子数组;

/**
 * ClassName p08.p_0803.最短无序子数组
 * Description TODO
 * Author 30712
 * Date 2021-08-03
 * Time 22:33
 */
public class Solution {
    //找出一个子数组，如果对这个子数组进行升序排列，那么整个数组都会变成升序排序
    public int findUnsortedSubarray(int[] nums){
        //将数组分为三个区域
        int len = nums.length;
        int min = nums[len-1],left=0;
        int max = nums[0] ,right =-1;
        for (int i=0;i< len ;i++){
            if (max > nums[i]){
                right =i;
            }else {
                max = nums[i];
            }

            if (min < nums[len-i-1]){
                left = len-i-1;
            }else {
                min = nums[len-i-1];
            }
        }
        //返回的是符合的最短子数组的长度
        return right -left+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(s.findUnsortedSubarray(nums));
    }
}
