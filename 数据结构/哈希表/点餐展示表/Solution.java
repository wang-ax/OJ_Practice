package p07.p_0706.点餐展示表;

import java.util.*;

/**
 * ClassName p07.p_0706.点餐展示表
 * Description TODO
 * Author 30712
 * Date 2021-07-06
 * Time 15:43
 */
public class Solution {
    /**
     * 哈希表 nameSet 保存所有的餐品名称；
     * 哈希表 foodsCnt 保存桌号及该桌点餐数量，点餐数量也用一个哈希表保存。
     * @param orders
     * @return
     */
    public static List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> nameSet = new HashSet<>();//保存餐品名称，菜品的名称有重复，使用Set
        //桌号，点餐的数量（菜品名称，该菜品点的个数）
        Map<Integer, Map<String,Integer>>  foodsCnt = new HashMap<>();
        for(List<String> order : orders){
            nameSet.add(order.get(2));//餐品名称
            int id = Integer.parseInt(order.get(1));//桌号
            Map<String,Integer> map = foodsCnt.getOrDefault(id,new HashMap<>());
            map.put(order.get(2),map.getOrDefault(order.get(2),0)+1);//餐品的名称，该餐品的数量
            foodsCnt.put(id,map);
        }

        //提取菜品的名称，并按字母顺序排列
        int n = nameSet.size();
        List<String> names = new ArrayList<>();
        for(String name : nameSet){
            names.add(name);
        }
        Collections.sort(names);//排序

        //提取桌号，并按照桌号进行升序排列
        int m = foodsCnt.size();
        List<Integer> ids = new ArrayList<>();
        for(int id : foodsCnt.keySet()){
            ids.add(id);
        }
        Collections.sort(ids);


        List<List<String>> table = new ArrayList<>();//展示表
        List<String> header = new ArrayList<>();//第一行
        header.add("Table");//第一行的第一列是Table
        for(String name:names){//第一行是标题，分别是菜品的名称
            header.add(name);
        }
        table.add(header);//第一行添加完毕

        for(int i =0;i<m;i++){
            int id = ids.get(i);
            Map<String,Integer> cnt = foodsCnt.get(id);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(id));
            for(int j=0;j<n;j++){
                row.add(Integer.toString(cnt.getOrDefault(names.get(j), 0)));
            }
            table.add(row);
        }
        return table;
    }

    public static void main(String[] args) {
        List<List<String>> order= new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("David");
        list1.add("3");
        list1.add("Ceviche");
        List<String> list2 = new ArrayList<>();
        list2.add("Corina");
        list2.add("10");
        list2.add("Beef Burrito");
        List<String> list3 = new ArrayList<>();
        list3.add("David");
        list3.add("3");
        list3.add("Fried Chicken");

        List<String> list4 = new ArrayList<>();
        list4.add("Carla");
        list4.add("5");
        list4.add("Water");
        List<String> list5 = new ArrayList<>();
        list5.add("Carla");
        list5.add("5");
        list5.add("Ceviche");
        List<String> list6 = new ArrayList<>();
        list6.add("Rous");
        list6.add("3");
        list6.add("Ceviche");

        order.add(list1);
        order.add(list2);
        order.add(list3);
        order.add(list4);
        order.add(list5);
        order.add(list6);


        List<List<String>> lists = displayTable(order);
        for(List<String> list : lists){
            System.out.println(list);
        }
    }
}
