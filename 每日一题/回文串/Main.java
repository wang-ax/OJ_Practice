package 回文串;

import java.util.Scanner;

/**
 * ClassName 回文串
 * Description TODO
 * Author 30712
 * Date 2021-03-11
 * Time 8:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.next();
            /*if(isHuiWen(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }*/
        }
    }

    /*private static boolean isHuiWen(String s) {


        //判断一个字符串添加一个字母后能不能变成一个回文串
        *//*int i =0;
        int j = s.length()-1;
        int num =0;
        while (i < j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                i++;
                num++;
            }
        }
        if (num <=1){
            return true;
        }
        return false;*//*
    }*/
}
