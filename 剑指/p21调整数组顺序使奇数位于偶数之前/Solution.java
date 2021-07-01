package p21调整数组顺序使奇数位于偶数之前;

/**
 * ClassName p21调整数组顺序使奇数位于偶数之前
 * Description TODO
 * Author 30712
 * Date 2021-06-05
 * Time 12:24
 */
public class Solution {
    public int[] exchange(int[] nums){
        //调整数组顺序使奇数位于偶数前面
        int i =0;
        int j = nums.length-1;
        while(i < j){
            while(i < j && nums[j] %2 == 0){
                j--;
            }
            while(i < j && nums[i] %2 != 0){
                i++;
            }
            swap(nums,i,j);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums =  {2,3,4,5,6,7,8,9,10};
        Solution solution = new Solution();
        int[] exchange = solution.exchange(nums);
        for (int e:exchange){
            System.out.println(e);
        }
    }
}
