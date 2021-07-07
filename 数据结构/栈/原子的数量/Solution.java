package p07.p_0705;

import java.util.*;

/**
 * ClassName p07.p_0705
 * Description TODO 括号序列相关的题目，使用递归或者栈，使用栈解决
 * 1.遍历化学式，使用哈希表记录当前层遍历到的原子及其数量
 *  左括号：将空的哈希表压入栈中
 * 不是括号：读取一个原子名和曾，若后面还有数字，读取一个数字，否则该原子后面的数字视为1.将原子及数字加入栈顶的哈希表
 * 如果是右括号，  则说明遍历完了当前层，若括号右侧还有数字，则读取该数字 num，否则将该数字视作 1。然后将栈顶的哈希表弹出，
 *              将弹出的哈希表中的原子数量与num 相乘，加到上一层的原子数量中。
 *
 *  遍历结束后，栈顶的哈希表即为化学式中的原子及其个数。遍历哈希表，
 * 取出所有「原子-个数」对加入数组中，对数组按照原子字典序排序，
 * 然后遍历数组，按题目要求拼接成答案。
 */
public class Solution {
    int i,n;
    String formula;
    public String countOfAtoms(String formula){
        this.i = 0;
        this.n  = formula.length();
        this.formula = formula;
        Deque<Map<String,Integer>> stack = new LinkedList<Map<String,Integer>>();
        stack.push(new HashMap<String,Integer>());
        while (i < n){
            char ch = formula.charAt(i);
            if (ch == '('){//左括号
                i++;
                stack.push(new HashMap<String,Integer>());//压入空的哈希表
            }else if(ch == ')'){
                i++;
                int num = parseNum(); // 括号右侧数字
                Map<String, Integer> popMap = stack.pop(); // 弹出括号内的原子数量
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int v = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + v * num); // 将括号内的原子数量乘上 num，加到上一层的原子数量中
                }
            }else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String,Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // 统计原子数量
            }
        }

        Map<String,Integer> map = stack.pop();
        TreeMap<String,Integer> treeMap = new TreeMap<>(map);
        StringBuffer stringBuffer = new StringBuffer();
        for(Map.Entry<String,Integer> entry : treeMap.entrySet()){
            String atom = entry.getKey();
            int count = entry.getValue();
            stringBuffer.append(atom);
            if (count > 1) {
                stringBuffer.append(count);
            }
        }
        return stringBuffer.toString();
    }

    private String parseAtom() {
        StringBuffer sb = new StringBuffer();
        sb.append(formula.charAt(i++));
        while (i < n && Character.isLowerCase(formula.charAt(i))){
            sb.append(formula.charAt(i++));
        }
        return sb.toString();
    }

    private int parseNum() {
        if (i==n || !Character.isDigit(formula.charAt(i))){
            return 1;
        }
        int num =0;
        while (i < n && Character.isDigit(formula.charAt(i))){
            num = num*10 + formula.charAt(i++)-'0';
        }
        return num;
    }

}