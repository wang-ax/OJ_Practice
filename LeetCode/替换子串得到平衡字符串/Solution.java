package 替换子串得到平衡字符串;

/**
 * ClassName 替换子串得到平衡字符串
 * Description TODO
 * Author 30712
 * Date 2021-05-08
 * Time 20:41
 */
public class Solution {
    public int balancedString(String s) {
        if (s == null || s.length() < 0) {
            return -1;
        }
        int n = s.length();//字符串的长度
        //如果Q，W，E，R 恰好都出现了n/4次，就是一个平衡字符串
        //窗口内部：需要替换的字符串,(多出来的元素)
        //窗口外部：已经满足要求的字符串
        //看窗口外的四种字符数量是否满足题目要求，如果满足的话，尝试缩小窗口尺寸以获得最小的替换长度，否则继续扩大窗口，知道满足条件的窗口出现
        int left = 0;
        int res = n;

        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'A']++;
        }
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'A']--;
            //窗口外的元素是否满足
            //统计符合条件的窗口的最小值
            while (left < n && freq['Q' - 'A'] <= n / 4 && freq['W' - 'A'] <= n / 4 && freq['E' - 'A'] <= n / 4 && freq['R' - 'A'] <= n / 4) {
                res = Math.min(res, right - left + 1);
                freq[s.charAt(left++) - 'A']++;
            }
        }
        return res;
    }
}
