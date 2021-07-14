package p44数字序列中某一位的数字;

/**
 * ClassName p44数字序列中某一位的数字
 * Description TODO
 * Author 30712
 * Date 2021-06-23
 * Time 16:25
 */
public class Solution {
    /**
     *          digit           count
     *  1-9     1位数   9个数字   数位数量9
     *  10-99   2位数   90个数字   180
     *  100-999  3     900       2700
     *  start-end digit  9*digit  9*start*digit
     */
    public static int findNthDigit(int n){
        /**
         * 确定n所在的数字的位数，digit
         * 确定n所在的数字 num
         * 确定n是num中的哪一数位
         */
        if (n < 10){
            return n;
        }
        int digit=1;
        long start = 1;
        long count =9;
        while (n > count){
            n -= count;
            digit +=1;
            start *=10;
            count = digit*start*9;
        }
        //得到所求的数位所在的数字
        long num = start+(n-1)/digit;
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }

    public static void main(String[] args) {
        int n =13;
        System.out.println(findNthDigit(n));
    }
}
