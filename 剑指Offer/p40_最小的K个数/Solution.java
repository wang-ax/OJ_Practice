package p40_最小的K个数;

import java.util.Random;

/**
 * ClassName p_最小的K个数
 * Description TODO
 * Author 30712
 * Date 2021-06-04
 * Time 15:43
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        /**
         * 暴力解法，直接进行排序，将最小的K个数输出
         */
//        int[] res = new int[k];
//        Arrays.sort(arr);
//        for (int i =0;i< k;i++){
//            res[i] = arr[i];
//        }
//        return res;


        /**
         * 使用堆解决
         */
//        int[] res = new int[k];
//        if (k == 0){
//            return res;
//        }
//        //使用一个大根堆，维护数组的前k小个值
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        //先将前k个元素插入大根堆中
//        for (int i =0;i<k;++i){
//            priorityQueue.offer(arr[i]);
//        }
//        /**
//         * 随后从第 k+1个数开始遍历，如果当前遍历到的数比大根堆的堆顶的数要小
//         * 就把堆顶的数弹出，再插入当前遍历到的数。最后将大根堆里的数存入数组返回即可
//         */
//        for (int i =k;i < arr.length;++i){
//            if (priorityQueue.peek()  > arr[i]){
//                priorityQueue.poll();
//                priorityQueue.offer(arr[i]);
//            }
//        }
//        for (int i=0;i<k;i++){
//            res[i] = priorityQueue.poll();
//        }
//        return res;



        /**
         * 快排的思想解决
         */
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;

    }
    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }
    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,1};
        int k =2;
        int[] minK = solution.getLeastNumbers(nums, k);
        for (int m : minK){
            System.out.println(m);
        }
    }
}
