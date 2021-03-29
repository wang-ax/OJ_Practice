package 颠倒二进制位;

/**
 * ClassName 颠倒二进制位
 * Description TODO
 * Author 30712
 * Date 2021-03-29
 * Time 22:57
 */
public class Solution {
    //循环32次，每次取出最后一维，放在新的数中，旧的数不断循环右移，新的数不断循环左移
    public int reverseBits(int n) {
        int num = 0;
        int temp = 0;
        for (int i = 0; i < 32; i++) {
            num = n&1;
            temp = (temp<<1)+num;
            n = n>>1;
        }
        return temp;
    }

}
