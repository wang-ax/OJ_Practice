package p_0619;

import java.util.List;

/**
 * ClassName p_0619
 * Description TODO
 * Author 30712
 * Date 2021-06-19
 * Time 15:35
 */
public class chuanlianzifuchuanmaxLength {
    private int max; //记录当前的最长的长度
    public int maxLength(List<String> arr) {
        if(arr == null){
            return 0;
        }
        dfs(arr,0,new StringBuilder());
        return max;
    }

    /**
     * 先判断要传进来的sb是不是满足每一个字符都只出现一次
     * @param arr
     * @param start
     * @param sb
     */
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

    /**
     * 判断sb中是不是每一个元素都只出现了一次
     * @param sb
     * @return
     */
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
    }
}
