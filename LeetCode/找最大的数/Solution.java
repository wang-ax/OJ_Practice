package 找最大的数;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName 找最大的数
 * Description TODO
 * Author 30712
 * Date 2021-04-12
 * Time 21:11
 */
public class Solution {
    public String largestNumber(int[] nums){
        String[] strings = new String[nums.length];
        for (int i=0;i< nums.length;i++){
            strings[i] = String.valueOf(nums[i]);
        }
//如果s1 + s2大于s2 + s1（这里的比较大小是用字符串的比较规则比较大小），则s1排在s2的前面。
        //字符串比较大小：长度不能直接决定大小，字符串的大小是由左边开始最前面的字符决定的
        //自定义排序
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i< strings.length;i++){
            stringBuilder.append(strings[i]);
        }
        //输出结果前需要去除结果中的前导0。如果去除完前导0后字符串的长度为0，说明该字符串中只有0，我们应该输出“0”
        while('0' == stringBuilder.charAt(0)) {
            stringBuilder.deleteCharAt(0);
            if (0 == stringBuilder.length()) {
                return "0";
            }
        }
        return stringBuilder.toString();
    }
}
