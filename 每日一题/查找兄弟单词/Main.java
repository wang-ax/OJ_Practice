package 查找兄弟单词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * ClassName 查找兄弟单词
 * Description TODO
 * Author 30712
 * Date 2021-03-18
 * Time 13:37
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();//字典中共有几个单词
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();//n个单词
            }
            //查找兄弟单词
            //要查找的单词
            String findString = scanner.next();
            int k = scanner.nextInt();//查找出来的兄弟单词中第k个单词
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //判断是不是兄弟单词，首先它们的长度要是一样的
                if (strings[i].length() == findString.length()) {
                    //如果是，就全部添加到链表中
                    if (checkBrother(findString, strings[i])) {
                        list.add(strings[i]);
                    }
                }
            }
            Collections.sort(list);
            System.out.println(list.size());
            if (list.size() >= k) {
                System.out.println(list.get(k - 1));
            }

        }
    }

    //判断是不是兄弟单词
    private static boolean checkBrother(String findString, String string) {
        char[] char1 = findString.toCharArray();
        char[] char2 = string.toCharArray();
        //Arrays的equals方法:比较的是字符串的内容是否相等
        //如果使用char1.equals(char2):比较的是两个对象是不是同一个对象
        if (Arrays.equals(char1,char2)){
            return false;
        }
        Arrays.sort(char1);
        Arrays.sort(char2);
        if (Arrays.equals(char1,char2)) {
            return true;
        }
        return false;
    }
}
