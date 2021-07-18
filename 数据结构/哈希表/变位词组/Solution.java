package p07.p_0718.变位词组;

import java.util.*;

/**
 * ClassName p07.p_0718.变为词组
 * Description TODO 变位词组
 * https://leetcode-cn.com/problems/group-anagrams-lcci/comments/
 * Author 30712
 * Date 2021-07-18
 * Time 9:17
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i=0;i < strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            //互为变为词的两个字符串，排序之后得到的字符串一定是相同的，所以
            //将排序之后的字符串作为哈希表的键
            String s = new String(chars);
            if (!map.containsKey(s)){
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(s,temp);
            }else {
                map.get(s).add(strs[i]);
            }
        }
        //遍历哈希表，将哈希表中的value值添加到res中
        for (String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(strings));
    }
}
