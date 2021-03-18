package 乒乓球筐;

/**
 * ClassName 乒乓球筐
 * Description TODO
 * Author 30712
 * Date 2021-03-18
 * Time 11:20
 */
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            boolean b = fin(s1, s2);
            if (b == true){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
    public static  boolean fin(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        //B盒中的所有球的类型都在A中有
        //每种球的数量都不大于A，A中的球的数量要大于等于B中对应的球的数量
        HashMap<Character ,Integer> map1 =new HashMap<>();
        HashMap<Character ,Integer> map2 =new HashMap<>();
        //A和B中的元素都放入HashMap中
        for(Character c : chars1){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(Character c : chars2){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        // int count =0;
        //要保证chars2中的每一个元素都是这样的
        for(int i =0;i< chars2.length;i++){
            if(map1.containsKey(chars2[i])){
                //说明map1中有这个元素
                //再比较map1中的这个元素的个数和map2中这个元素的个数
                //如果是大于等于说明，YES
                int count1 = map1.get(chars2[i]);
                int count2 = map2.get(chars2[i]);
                if (count1 >= count2){
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
