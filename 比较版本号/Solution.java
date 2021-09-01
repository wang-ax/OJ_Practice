package p09.p_0901.比较版本号;

/**
 * ClassName p09.p_0901.比较版本号
 * Description TODO
 * Author 30712
 * Date 2021-09-01
 * Time 11:32
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        //比较版本号
        //用 . 将字符串进行切割
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i=0;i < v1.length || i < v2.length;i++){
            int x =0;
            int y =0;
            if(i < v1.length){
                //字符串转换成整数进行比较
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length){
                y = Integer.parseInt(v2[i]);
            }
            if (x > y){
                return 1;
            }
            if ( x < y){
                return -1;
            }

        }
        return 0;
    }
}
