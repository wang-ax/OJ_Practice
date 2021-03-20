package 字符串加密;

import java.util.Scanner;

/**
 * ClassName 字符串加密
 * Description TODO
 * Author 30712
 * Date 2021-03-13
 * Time 14:27
 */
public class Main {
    public static String encryption(String s){
        StringBuilder stringBuilder =new StringBuilder();
        //加密
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c >='0' && c <='9'){
                //是数字
                if ( c == '9'){
                    c = '0';
                }else {
                    c= (char) (c+1);
                }
            }

            //如果是小写字母
            if ( c >='a' && c <='z'){
                if (c == 'z'){
                    c = 'A';
                }else {
                    c = (char)(c+1);
                    //将小写字母转换为大写
                    c = (char) (c -32);
                }
            }else if ( c >='A' && c <='Z'){
                if (c == 'Z') {
                    c = 'a';
                }else {
                    c = (char) (c + 1);
                    //将大写字符转换位小写字符
                    c = (char) (c +32);
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    public static  String unEncryption(String s){
        StringBuilder stringBuilder = new StringBuilder();
        //解密
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c >='0' && c <='9'){
                //是数字
                if ( c == '0'){
                    c = '9';
                }else {
                    c= (char) (c-1);
                }
            }
            //如果是小写字母
            if ( c >='a' && c <='z'){
                if (c == 'a'){
                    c = 'Z';
                }else {
                    c = (char)(c-1);
                    //将小写字母转换为大写
                    c = (char) (c -32);
                }
            }else if ( c >='A' && c <='Z'){
                if (c == 'A') {
                    c = 'z';
                }else {
                    c = (char) (c - 1);
                    //将大写字符转换位小写字符
                    c = (char) (c +32);
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.nextLine();//要加密的秘密，进行加密
            String s2 = scanner.nextLine();//要解密的密码，进行解密
            System.out.println(encryption(s1));
            System.out.println(unEncryption(s2));
        }
    }
}
