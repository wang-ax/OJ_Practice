package 简单错误记录;

import java.util.Scanner;

/**
 * ClassName 简单错误记录
 * Description TODO
 * Author 30712
 * Date 2021-03-19
 * Time 8:54
 */
/**
 * 相同的文件名称和相同的行数，只记录一次，但是错误的次数增加
 * 超过16个字符的文件名称，只记录文件的最后有效16个字符
 *
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>(); //LinkedHashMap而不是hashmap！！！！！
        String key;
        String filename;
        String path;
        while(in.hasNext()){
            path = in.next();
            //将路径转换为文件名
            int id = path.lastIndexOf('\\');//先得到文件的名称
            //如果找不到说明只有文件名没有路径
            filename = id<0  ? path : path.substring(id+1);
            int linenum = in.nextInt();
            //统计出现的次数
            key = filename+" "+linenum;
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }

            List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
                //降序
                @Override
                public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
                    return(arg1.getValue()-arg0.getValue()) == 0? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
                }
            });

            //只输出前8条
            int m=0;
            for(Map.Entry<String, Integer> mapping : list){
                m++;
                if(m<=8){
                    String[] str = mapping.getKey().split(" ");
                    //超过16个字符的文件名称，只记录文件的最后有效16个字符
                    String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                    String n = str[1];
                    System.out.println(k+" "+n+" "+mapping.getValue());
                }else{
                    break;
                }
            }
        }
    }
}
