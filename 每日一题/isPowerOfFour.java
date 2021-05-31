/**
 * ClassName PACKAGE_NAME
 * Description TODO
 * Author 30712
 * Date 2021-05-31
 * Time 18:09
 */
public class isPowerOfFour {
    public static boolean isPowerOfFour(int n){
        //循环
        //如果是4的幂那一定是2的幂
/*        if( n <= 0){
            return false;
        }
        int temp =0;
        while( n > 1){
            temp = n %4;
            if(temp != 0){
                return false;
            }
            n = n/4;
        }
        return true;*/

        //递归
//        if (n ==1 ){
//            return true;
//        }else if(n == 0 || n/4*4 != n){//不是4的倍数
//            return false;
//        }else if (n == 4){
//            return true;
//        }
//        return isPowerOfFour(n /4);

        //位运算
        //如果是4的幂，二进制位表示中有且仅有一个1，并且之歌1出现在从低位开始的第偶数个二进制位上
        //构造一个整数：所有偶数二进制位都是0，所有奇数二进制位都是1
        int x = 0x55555555;
        return (n > 0)&&((n&(n-1))==0)&((n&x) == n);

    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
}
