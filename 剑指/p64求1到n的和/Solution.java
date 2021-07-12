package p64求1到n的和;

/**
 * ClassName p64求1到n的和
 * Description TODO
 * Author 30712
 * Date 2021-06-29
 * Time 16:24
 */
public class Solution {
    public static int sumNums(int n) {
        //1+2+3+...+n
        //递归
/*        if (n == 1){
            return 1;
        }
        n+=sumNums(n-1);
        return n;*/

        /**
         * 递归的终止条件和如何进行下一步的递归
         * 不能使用if进行判断
         * 使用 && 运算符，同样能够及逆行条件判断
         * 操作符的短路特性
         * A && B
         * 只有条件A满足的话，才会对条件B进行判断；否则就不会对条件B进行判断
         */
        boolean flag = (n > 0) && ((n += sumNums(n-1)) > 0) ;
        return n;
    }

    public static void main(String[] args) {
        int n =10;
        System.out.println(sumNums(n));
    }
}
