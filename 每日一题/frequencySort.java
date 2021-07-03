package p07.p_0703;



import java.util.*;

/**
 * ClassName p07.p_0703
 * Description TODO
 * Author 30712
 * Date 2021-07-03
 * Time 11:32
 */
class Node{
    char c;
    int value;

    public Node(char c, int value) {
        this.c = c;
        this.value = value;
    }
}
public class frequencySort {
    public String frequencySort2(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2)-map.get(o1);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i=0;i< size;i++){
            char c  = list.get(i);
            int frequency = map.get(c);
            for (int j=0;j < frequency;j++){
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
    public String frequencySort(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        //使用哈希表统计每个字符出现次数
        for (int i=0;i<chars.length;i++){
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((a,b)->{
            if (b.value != a.value) {
                //倒序
                return b.value - a.value;
            }
            //出现的次数相同，就按照字典序进行排序
            return a.c - b.c;
        });
        for (char  c: map.keySet()){
            priorityQueue.add(new Node(c,map.get(c)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            Node poll = priorityQueue.poll();
            int k = poll.value;
            while (k > 0){
                stringBuilder.append(poll.c);
                k--;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        frequencySort frequencySort = new frequencySort();
        System.out.println(frequencySort.frequencySort("tree"));
    }
}
