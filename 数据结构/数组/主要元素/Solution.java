package p07.p_0709.主要元素;

/**
 * ClassName p07.p_0709.主要元素
 * Description TODO
 * Author 30712
 * Date 2021-07-09
 * Time 9:47
 */
class Solution {
    /**
     * 投票算法：在每一轮投票过程中，从数组中删除两个不同的元素，直到投票过程无法继续，此时数组为空或数组中剩下的元素都相等
     * 数组为空：数组中不存在主要元素
     * 数组中剩下的元素都相等，数组中剩下的元素可能为主要元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //找出数组中超过一半的元素
        int candidate = 0;//候选的主要元素
        int count =0;//候选的主要元素出现的次数
        for(int i=0;i< nums.length;i++){
            if(count == 0){
                candidate = nums[i];
            }
            if(candidate == nums[i]){
                count++;
            }else{
                count--;
            }
        }

        //上面结束得到的candidate不确定是不是主要元素，所以需要再遍历一遍得到candidate的次数
        //如果是大于数组长度的一半，才是主要元素
        //否则就返回的是-1

        //重新计算count——>candidate出现的次数是否大于nums.length/2
        count =0;
        for(int i=0;i< nums.length;i++){
            if(nums[i] == candidate){
                count++;
            }
        }
        if(count > nums.length/2){
            return candidate;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,5,9,5,9,5,5,5};
        int[] nums1 = {3,2};
        System.out.println(s.majorityElement(nums));
        System.out.println(s.majorityElement(nums1));
    }
}
