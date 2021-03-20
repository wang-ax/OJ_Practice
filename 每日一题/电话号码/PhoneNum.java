package 电话号码;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * ClassName 电话号码
 * Description TODO
 * Author 30712
 * Date 2021-03-17
 * Time 8:27
 */
public class PhoneNum {
    public static void main(String[] args) {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String s2 = "222333444555666777788899991234567890";

        Scanner scanner= new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();//有n 行的电话号码
            ArrayList<String> list = new ArrayList<>();
            for (int i =0;i< n;i++){
                String s = scanner.next();
                s = s.replace("-","");//-替换成空字符串
                String result = "";
                for (int j =0;j < 7;j++){
                    //先从输入的s中依次遍历各个字符
                    //在s1中找到其对应的位置
                    //再得到s2中的位置，从而得到对应的字符
                    result+=s2.charAt(s1.indexOf(s.charAt(j)+""));
                }
                //最终得到的结果要将原先的-加上，而且是按照***-****的方式输出的
                result = result.substring(0,3)+"-"+result.substring(3,7);
                if (!list.contains(result)){
                    list.add(result);
                }
            }
            Collections.sort(list);
            for (int j =0;j <list.size();j++){
                System.out.println(list.get(j));
            }
            System.out.println();
        }
    }

}
