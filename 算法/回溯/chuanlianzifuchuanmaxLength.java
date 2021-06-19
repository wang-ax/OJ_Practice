package p_0619;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName p_0619
 * Description TODO
 * Author 30712
 * Date 2021-06-19
 * Time 15:35
 */
public class chuanlianzifuchuanmaxLength {
    /*private int max; //记录当前的最长的长度
    public int maxLength(List<String> arr) {
        if(arr == null){
            return 0;
        }
        dfs(arr,0,new StringBuilder());
        return max;
    }

    *//**
     * 先判断要传进来的sb是不是满足每一个字符都只出现一次
     * @param arr
     * @param start
     * @param sb
     *//*
    private void dfs(List<String> arr, int start, StringBuilder sb) {
        if(isRepeat(sb)){
            return;
        }
        max = Math.max(max,sb.length());
        for (int i= start;i < arr.size() ;i++){
            String s = arr.get(i);
            sb.append(s);
            dfs(arr,start+1,sb);
            sb.delete(sb.length()-s.length(), sb.length());
        }
    }

    *//**
     * 判断sb中是不是每一个元素都只出现了一次
     * @param sb
     * @return
     *//*
    private boolean isRepeat(StringBuilder sb) {
        int[] count = new int[26];
        for (int i=0;i< sb.length();i++){
            char c = sb.charAt(i);
            count[c-97]++;
            if (count[c-97] > 1){
                return true;
            }
        }
        return false;
    }*/

    int maxLength = 0;
    public int maxLength(List<String> arr) {
        ArrayList<String> strs = new ArrayList<>();
        dfs(arr, 0, strs);
        return maxLength;
    }
    public void dfs(List<String> arr, int startIndex, ArrayList<String> strs) {
        if (check(strs)){
            int tempLen = 0;
            for (String str : strs) {
                tempLen += str.length();
            }
            if (tempLen > maxLength){
                maxLength = tempLen;
            }
        }

        for (int i = startIndex; i < arr.size(); i++){
            strs.add(arr.get(i));
            dfs(arr, i+1, strs);
            strs.remove(strs.size()-1);
        }
    }
    public boolean check(ArrayList<String> strs) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++){
                if (map.get(str.charAt(i)) != null && map.get(str.charAt(i)) == true){
                    return false;
                }
                map.put(str.charAt(i), true);
            }
        }
        return true;
    }
}
