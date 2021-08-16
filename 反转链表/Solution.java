package p08.p_0815.反转链表;

/**
 * ClassName p08.p_0815.反转链表
 * Description TODO
 * Author 30712
 * Date 2021-08-15
 * Time 23:35
 */
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode reverse(ListNode head){
        if (head == null){
            return null;
        }
        ListNode newHead = null;//新链表的头结点
        ListNode current = head;//当前结点
        ListNode prev  = null;//当前需要翻转的结点的前面的结点
        while (current != null){
            ListNode currentNext = current.next;//先将当前节点的后序结点保存
            if (currentNext == null){
                newHead = current;
            }
            current.next = prev;
            prev = current;
            current = currentNext;

        }
        return newHead;
    }
}
