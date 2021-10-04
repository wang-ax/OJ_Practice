package zifuchuan;

import java.util.HashMap;

/**
 * ClassName zifuchuan
 * Description TODO 无重复字符的最长子串
 * Author 30712
 * Date 2021-09-28
 * Time 10:23
 */

/**
 * 输入：abcabcbb
 * 输出：3
 *
 * 输入：bbbbb
 * 输出：1
 *
 * 输入：pwwkew
 * 输出：3  ——无重复字符的最长子串是wke
 */
public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        //滑动窗口start-end
        int ans =0;
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int start =0;
        int end =0;

        for (start =0,end =0;end < n;end++){
            char a = s.charAt(end);
            //如果a在map中，就更新start的位置
            if (map.containsKey(a)){
                start = Math.max(map.get(a),start);
            }

            ans = Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans ;
    }

    public static void main(String[] args) {
        String  s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
