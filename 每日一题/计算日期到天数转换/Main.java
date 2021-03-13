package 计算日期到天数转换;

import java.util.Scanner;

/**
 * ClassName 计算日期到天数转换
 * Description TODO
 * Author 30712
 * Date 2021-03-13
 * Time 14:54
 */

/**
 * 一年一共有365天或者366天，平年有365天，闰年有366天，闰年每隔4年一次。
 * 平年的2月是28天，闰年2月是29天。
 * 4月、6月、9月、11月各是30天。
 * 1月、3月、5月、7月、8月、10月、12月各是31天。
 */
public class Main {
    //输入某年某月某日，判断这一天使这一年的第几天
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            System.out.println(iCoverDateToDay(year, month, day));
        }
    }
    public static int iCoverDateToDay(int year,int month,int day){
        int[] Month = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (year <=0 || month <=0 ||month >12 || day<=0 || day > 31){
            return -1;
        }
        //闰年
        if ((year %4 == 0 && year%100 != 0)  || year %400  == 0){
            //2月有29天
            Month[1] = 29;
        }
        //不是闰年
        //2月有28天
        int result = 0;
        for (int i =0;i< month-1;i++){
            result = result+Month[i];
        }
        return result+day;
    }
}
