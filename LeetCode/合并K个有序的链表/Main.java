package 合并K个有序的链表;

/**
 * ClassName 合并K个有序的链表
 * Description TODO
 * Author 30712
 * Date 2021-03-13
 * Time 19:33
 */
public class Main {
    static  class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static  ListNode mergeKList(ListNode[] lists ){
        /**
         * 暴力解法：
         * 1.遍历所有的链表，将所有节点的值放到一个数组中去
         * 2.将这个数组进行排序
         * 3.利用数组中的值，创建一个新的有序链表
         *
         * 时间复杂度：O(n)
         * 遍历所有的值O(N),稳定的排序算法需要O(nLog(n))，遍历的同时创建新的有序链表花费O(n)的时间
         * 空间复杂度：O(N)
         * 排序花费O(n)
         * 创建一个链表花费O(n)的空间
         */

        /**
         * 逐一进行比较：
         * 时间复杂度：O(kN)
         * 空间复杂度：O(N)
         */

        /**
         * 使用优先级队列
         * 时间复杂度：考虑优先队列中的元素不超过 k个，那么插入和删除的时间代价为 O(log k)，这里最多有 kn个点，对于每个点都被插入删除各一次，故总的时间代价即渐进时间复杂度为 )O(kn×log k)。
         * 空间复杂度：这里用了优先队列，优先队列中的元素不超过 k 个，故渐进空间复杂度为 O(k)
         */
       /* if (lists.length == 0){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;//从小到大，堆顶元素最小
            }
        });
        for (ListNode list :lists){
            if (list == null){
               continue;
            }
            priorityQueue.add(list);
        }
        while (!priorityQueue.isEmpty()){
            ListNode nextNode = priorityQueue.poll();//每次取出最小
            temp.next = nextNode;
            temp = temp.next;
            if (nextNode.next != null){
                priorityQueue.add(nextNode.next);
            }
        }
        return newHead.next;*/


        /**
         * 分治
         */
        if (lists == null || lists.length == 0){
            return null;
        }
        return merge(lists,0,lists.length-1);

    }

    private static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right){
            return lists[left];
        }
        int mid = left+(right - left)/2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        return mergeTwoList(l1,l2);
    }
    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if ( l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }
}
