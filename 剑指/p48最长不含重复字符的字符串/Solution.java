package p48最长不含重复字符的字符串;

import java.util.HashMap;

/**
 * ClassName p48最长不含重复字符的字符串
 * Description TODO
 * Author 30712
 * Date 2021-07-07
 * Time 16:55
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans =0;
        /**
         * key：字符
         * value ：字符位置+1（表示冲字符位置后一个才开始不重复）
         * 无论是否更新start，都会更新map和结果ans
         */
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int start =0;
        int end =0;
        for (start =0,end =0;end < n;end++){
            char a = s.charAt(end);
            if (map.containsKey(a)){
                start = Math.max(map.get(a),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
