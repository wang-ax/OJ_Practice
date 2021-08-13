package p56_II数组中数字出现的次数II;

/**
 * ClassName p56_II数组中数字出现的次数II
 * Description TODO
 * Author 30712
 * Date 2021-08-11
 * Time 10:16
 */
public class Solution {
    public int singleNumber(int[] nums) {
        //其他数字都出现了三次，只有一个数字出现了一次
        //使用HashMap记录各个数字出现的次数
       /* HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //遍历map中的entry
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;*/

/*        Arrays.sort(nums);
        int left =0;
        int right =1;
        while (left < right && right < nums.length){
            if (nums[left] != nums[right]){
                return nums[left];
            }
            while (left< right && nums[left] == nums[right]){
                right++;
            }
            left = right;
            right = left+1;
        }
        return nums[left];*/

        //出现三次的数字，各位出现的次数都是3的倍数
        //统计所有数字的个二进制位中1的个数，并对3求余，最终得到的结果为只出现一次的数字
        int[] count = new int[32];
        for (int num : nums){
            for (int j=0;j<32 ;j++){
                count[j] += num & 1;
                num >>>=1;
            }
        }
        int res =0;
        //将count各元素对3进行求余，结果为“只出现一次的数字”的各二进制位
        for (int i=0;i<32 ;i++){
            count[i] = count[i] % 3;
            if (count[i] == 1){
                res += Math.pow(2,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,7,9,7,9,7};
        Solution s = new Solution();
        System.out.println(s.singleNumber(nums));
    }
}
