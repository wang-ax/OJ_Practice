package 坐标移动;

import java.util.Scanner;

/**
 * ClassName 坐标移动
 * Description TODO
 * Author 30712
 * Date 2021-03-12
 * Time 8:18
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int x = 0;
            int y = 0;
            String str = sc.nextLine();
            String[] strings = str.split(";");
            for (String s : strings) {
                //无效
                if ("".equals(s) || s.length() > 3 || s.length()<3) {
                    continue;
                }
                //此时字符串中就只有三位，第一位是控制方向，第2，3位是控制移动多少
                //要保证后面的两位都是数字
                int value =0;
                for(int i = 1; i < s.length(); i++){
                    int index = s.charAt(i) - '0';
                    if(index < 0 || index > 9){
                        break;
                    }
                    if(i == 1 && s.length() != 2){
                        value += index * 10;
                    }else{
                        value += index;
                    }
                }
                char c = s.charAt(0);
                switch (c) {
                    case 'A'://向左
                        x -= value;
                        break;
                    case 'S'://向下
                        y -= value;
                        break;
                    case 'W'://向上
                        y += value;
                        break;
                    case 'D'://向右
                        x += value;
                        break;
                }
                System.out.println(x + "," + y);
            }

        }
    }
}
