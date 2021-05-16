package 寻找旋转数组中的最小值;

/**
 * ClassName 寻找旋转数组中的最小值
 * Description TODO
 * Author 30712
 * Date 2021-05-16
 * Time 20:27
 */
public class Solution {
    public int findMin1(int[] nums){
        //暴力遍历找到数组中最小的元素
        int min = nums[0];
        for(int i =1; i  < nums.length ;i++){
            if(min > nums[i]){
                min = nums[i];
            }
        }
        return min;
    }
    public int findMin2(int[] nums){
        //遍历数组，找到了比前一个数小的数字，就是数组的最小值；如果遍历完整个链表没有找到，那么最小值就是第一个元素
        for(int i =1;i < nums.length;i++){
            if (nums[i]  < nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }
    //二分查找，数组中的元素不重复
    public int findMin3(int[] nums){
        int left =0;
        int right = nums.length-1;
        while (left < right){//保证搜索的区间中存在一个元素
            int mid = left+(right-left)/2;
            if (nums[mid] > nums[right]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }
}
