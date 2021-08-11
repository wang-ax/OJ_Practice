package p08.p_0811;

/**
 * ClassName p08.p_0811
 * Description TODO BF算法
 * Author 30712
 * Date 2021-08-11
 * Time 18:47
 */
public class TestBF {
    /**
     * 时间复杂度O(M*N)——>M是主串的长度，N是子串的长度
     * @param str
     * @param sub
     * @return
     */
    public static  int BF (String str,String sub){
        if (str == null || sub == null){
            return -1;
        }
        int lenStr = str.length();
        int lenSub = sub.length();
        if (lenStr == 0 || lenSub == 0){
            return -1;
        }
        int i = 0;//遍历主串
        int j = 0;//遍历子串
        //如果j遍历完了，找到了——>返回i-j
        //如果i遍历完了——没有找到
        while (i < lenStr && j < lenSub){
            if (str.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else {
                i = i-j+1;
                j=0;
            }
        }
        if (j >= lenSub){
            return i-j;
        }
        return -1;

    }
    public static void main(String[] args) {
        System.out.println(BF("ababcabcdabcde","abcd"));
    }

}
