package 木棒拼图;

import java.util.*;

/**
 * ClassName 木棒拼图
 * Description TODO
 * Author 30712
 * Date 2021-03-08
 * Time 17:17
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i =0;i< n;i++){
            int[] array = new int[2];
            array[0] = sc.nextInt();
            array[1] = sc.nextInt();
            if(array[0] == 1){
                list.add(array[1]);
            }else{
                if(list.contains(array[1])){
                    list.remove((Object)array[1]);//删除的是这个元素，而不是这个下标处的元素
                }
            }
            //判断集合中的这些木棒能不能构成一个简单多边形
            //最长的一条边小于其余边的和
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            //System.out.println(list);
            int sum=0;
            Object[] arr = list.toArray();
            for (int j=0;j< arr.length-1;j++){
                sum += (int)arr[j];
            }
            //System.out.println(sum);
            int last = (int) arr[arr.length-1];
            if (last < sum){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
