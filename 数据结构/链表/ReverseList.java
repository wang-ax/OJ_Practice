package lianbiao;

/**
 * ClassName lianbiao
 * Description TODO
 * Author 30712
 * Date 2021-09-14
 * Time 12:16
 */
class ListNode{
    int val;
    ListNode next;
    //构造方法
    public ListNode(int val) {
        this.val = val;
    }
}
public class ReverseList {
    //反转链表
    public ListNode reverse (ListNode head){
        ListNode newHead= null;//新链表的头节点
        ListNode current = head;//当前需要反转的节点
        ListNode prev = null;
        while (current != null){
            ListNode currentNext = current.next;
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
