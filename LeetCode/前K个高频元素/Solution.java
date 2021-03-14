package 前K个高频元素;

import java.util.*;

/**
 * ClassName 前K个高频元素
 * Description TODO
 * Author 30712
 * Date 2021-03-14
 * Time 19:59
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //前k个出现频率最高的元素
        //这种题目就是topK问题的转变
        //优先级队列
        //哈希表
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //int[]的第一个元素代表的是数组的值，第二个元素代表的是该值出现的次数
        //优先级队列中传入的是数组
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];//按照出现的次数进行排序
            }
        });

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            //如果优先级队列中的元素小于K就直接插入
            //如果等于K，就需要进行比较
            if (queue.size() == k) {
                //查看堆顶与当前出现的次数的大小
                //如果堆顶大，舍弃当前值
                //否则，就将堆顶元素弹出，将当前的值插入堆中
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                    queue.offer(new int[]{num,count});
            }
        }
        int[] result = new int[k];
        for (int i =0;i<k;i++){
            result[i] = queue.poll()[0];//将数组的值以数组的形式输出
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k =2;
        Solution solution= new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }
}
