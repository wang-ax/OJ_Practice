package p07.p_0724.替换隐藏数字得到的最晚时间;

/**
 * ClassName p07.p_0724.替换隐藏数字得到的最晚时间
 * Description TODO
 * Author 30712
 * Date 2021-07-24
 * Time 9:12
 */
public class Solution {
    public static String maximumTime(String time) {
        String[] strings = time.split(":");
        char[] chars1 = strings[0].toCharArray();
        char[] chars2 = strings[1].toCharArray();

        if (chars1[0] == '?'){
            chars1[0] = ('4' <= chars1[1] && chars1[1] <= '9') ? '1' : '2';
        }
        if (chars1[1] == '?'){
            //最多是23时50分，所以如果chars1[0]是2，那么chars[1]就是3
            chars1[1] = (chars1[0] == '2') ? '3' :'9';
        }

        if (chars2[0] == '?'){
            chars2[0] ='5';
        }
        if (chars2[1] == '?'){
            chars2[1] = '9';
        }
        String s1 =  new String(chars1);
        String s2 =  new String(chars2);
        return s1+":"+s2;
    }

    public static void main(String[] args) {
        String time = "?0:3?";
        System.out.println(maximumTime(time).toString());
    }
}
