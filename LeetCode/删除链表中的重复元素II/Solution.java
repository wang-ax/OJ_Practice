package 删除链表中的重复元素II;
/**
 * ClassName 删除链表中的重复元素II
 * Description TODO
 * Author 30712
 * Date 2021-03-25
 * Time 21:07
 */
class ListNode {
    int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
    public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        //删除排序链表中的重复元素
        if(head == null|| head.next == null){
            return head;
        }
        /**
         * 遍历一次链表
         */
        //可能会删除head节点，所有用虚拟节点
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode current = head;
        while (current != null){
            while (current.next != null && current.val == current.next.val){
                current = current.next;
            }
            if (prev.next == current){
                //prev和current之间没有重复的节点，prev向后移动
                prev = prev.next;
            }else {
                //跳过了重复的元素
                prev.next= current.next;
            }
            current = current.next;
        }

       /* 错的
        ListNode current = head;
        while (current.next != null){
            if (current.val != current.next.val){
               newHead.next = current;
            }
            current = current.next;
        }*/
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1= head.next = new ListNode(2);
        ListNode node2 = node1.next = new ListNode(3);
        ListNode node3 = node2.next = new ListNode(3);
        ListNode node4 = node3.next = new ListNode(5);
        System.out.println(deleteDuplicates(head));
    }
}
