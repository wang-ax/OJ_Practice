package p08.p_0815.字符串相加;

/**
 * ClassName p08.p_0815.字符串相加
 * Description TODO
 * Author 30712
 * Date 2021-08-15
 * Time 23:49
 */
public class Solution {
    //字符串相加

    /**
     * 双指针
     * 计算进位
     * 添加当前进位
     * 索引溢出处理
     * 遍历完之后，根据carry的值决定是否在头部添加进位1，最终返回res
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry =0;
        while (i >=0 || j >=0){
            int n1 = i >=0 ? num1.charAt(i) -'0': 0;
            int n2 = j >=0 ? num2.charAt(j) -'0': 0;
            int temp = n1 + n2 + carry;

            carry = temp/10;

            res.append(temp% 10);

            i--;
            j--;
        }

        if (carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "051189";
        String s2 = "967895";
        Solution s = new Solution();
        System.out.println(s.addStrings(s1, s2));
    }
}
