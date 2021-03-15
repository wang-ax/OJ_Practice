package 餐馆;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ClassName 餐馆
 * Description TODO
 * Author 30712
 * Date 2021-03-06
 * Time 20:30
 */

/**
 * n张桌子，每张桌子的参数为a
 * 有m批客人，每批客人有两个参数：人数和预计消费金额
 * 总的消费金额最大
 */
public class Main {
    static class Customer implements Comparable<Customer> {
        private int peopleCount;//人数
        private int moneyCount;//消费金额

        public Customer(int peopleCount, int moneyCount) {
            this.peopleCount = peopleCount;
            this.moneyCount = moneyCount;
        }

        @Override
        public int compareTo(Customer o) {
            if(o.moneyCount > this.moneyCount) return 1;
            else if(o.moneyCount < this.moneyCount) return - 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] desk = new int[n];
            for (int i =0;i < n;i++){
                desk[i] = scanner.nextInt();
            }
            Arrays.sort(desk); // 桌子容纳量从小到大排序
            PriorityQueue<Customer> queue = new PriorityQueue<>(); // 将客人按消费额降序加入优先级队列
            //m批客人
            for (int i = 0; i < m; i ++) {
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                if(b <= desk[n - 1]) {
                    queue.add(new Customer(b, c)); // 如果人数小于桌子最大容纳量,加入队列
                }
            }
            boolean[] visited = new boolean[n]; // 记录桌子是否被占用
            long sum = 0; // 记录总盈利
            int count = 0; // 记录已使用的桌子数
            while ( ! queue.isEmpty()) {
                Customer customer = queue.poll();
                for (int i = 0; i < n; i ++) { // 为客人分配桌子
                    if(customer.peopleCount <= desk[i] && ! visited[i]) {
                        sum += customer.moneyCount;
                        visited[i] = true;
                        count ++;
                        break;
                    }
                }
                if(count == n) {
                    break;
                }
            }
            System.out.println(sum);
        }
    }
}
