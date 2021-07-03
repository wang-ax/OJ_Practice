package p67字符串转换成整数;

import java.util.Arrays;

/**
 * ClassName p67字符串转换成整数
 * Description TODO
 * Author 30712
 * Date 2021-07-03
 * Time 15:01
 */
public class Solution {
    public int strToInt(String str) {//字符串转换成整数
        str = str.trim();//先去空格
        //再判断是否为空
        if (str.length() == 0 || str.isEmpty()){
            return 0;
        }
        boolean isMinus = false;//需要记录是不是负数
        char[] chars = str.toCharArray();
        //合法的首位字符
        if (chars[0] == '+' || chars[0] == '-' ||Character.isDigit(chars[0])){
            if (chars[0] == '+' || chars[0] == '-'){
                if (chars[0] == '-'){
                    isMinus = true;
                }
                //删除首位
                chars = Arrays.copyOfRange(chars,1,chars.length);
            }
            //首位后面的字符是不是数字，直到最后一个数字
            int index=0;
            long res =0;
            while (index < chars.length && Character.isDigit(chars[index])){
                res *=10;
                res +=chars[index] -'0';
                //有超过了int范围的直接return
                if (res > Integer.MAX_VALUE){
                    return isMinus ? Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                index++;
            }
            //long类型转为int类型
            return isMinus ? -(int) res : (int) res;
        }
        //首位是除了正负号和合法的整数之外的其他字符，直接返回
        return 0;
    }
}
