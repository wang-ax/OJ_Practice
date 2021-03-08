package 下一个更大元素;

import java.util.HashMap;
import java.util.Stack;

/**
 * ClassName 下一个更大元素
 * Description TODO
 * Author 30712
 * Date 2021-03-08
 * Time 11:57
 */

/**
 * 通过Stack、HashMap解决
 * 先遍历大数组nums2，首先将第一个元素入栈；
 * 继续遍历，当当前元素小于栈顶元素时，继续将它入栈；当当前元素大于栈顶元素时，栈顶元素出栈，此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
 * 当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
 * 遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] result = new int[nums1.length];

        for (int num:nums2){
            while (!stack.isEmpty() && stack.peek()< num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        for (int i=0;i< nums1.length;i++){
            result[i] = map.getOrDefault(nums1[i],-1);
        }
        return result;
    }
}
