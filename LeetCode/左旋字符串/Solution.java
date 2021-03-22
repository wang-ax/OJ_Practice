package 左旋字符串;

/**
 * ClassName 左旋字符串
 * Description TODO
 * Author 30712
 * Date 2021-03-22
 * Time 20:40
 */
public class Solution {
    public static String reverseLeftWords(String s, int n) {
        //直接进行字符串拼接
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n,s.length()));
        sb.append(s.substring(0,n));
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int n =2;
        System.out.println(reverseLeftWords(s, 2));
    }
}
