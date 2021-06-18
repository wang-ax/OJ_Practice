package p13罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName p_13罗马数字转整数
 * Description TODO
 * Author 30712
 * Date 2021-06-04
 * Time 17:42
 */
class Solution {
    public  static int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            //前一个数字如果比后一个数字小，就说明该数是由两个罗马数字组成的
            //减去小的加上大的，最终的结果不发生变化
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));

    }
}
