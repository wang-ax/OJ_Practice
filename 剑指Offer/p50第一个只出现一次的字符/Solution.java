package p50第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName p50第一个只出现一次的字符
 * Description TODO
 * Author 30712
 * Date 2021-06-05
 * Time 17:17
 */
public class Solution {
    public char firstUniqChar(String s) {
        /**
         *
         */
//        HashMap<Character,Integer> map = new HashMap<>();
//        //第一次遍历得到每一个数字出现的次数
//        for (int i =0;i< s.length();i++){
//            char ch = s.charAt(i);
//            map.put(ch,map.getOrDefault(ch,0)+1);
//        }
//
//        //再通过遍历得到第一次出现一次的字符
//        for (int i =0;i< s.length();i++){
//            if (map.get(s.charAt(i)) ==1 ){
//                return s.charAt(i);
//            }
//        }
//        return ' ';


        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));

        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';

    }
}
