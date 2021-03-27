package 旋转链表;

/**
 * ClassName 旋转链表
 * Description TODO
 * Author 30712
 * Date 2021-03-27
 * Time 20:41
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null ){
            return head;
        }
        int len =0;
        ListNode current = head;
        while (current != null){
            len +=1;
            current = current.next;
        }
        k %=len;
        if (k == 0){
            return  head;
        }
        //找到倒数第k个节点和倒数第k+1个节点
        ListNode fast = head;
        ListNode slow = head;
        while (k != 0){
            fast = fast.next;
            k -=1;
        }
        while (fast.next!= null){
            fast = fast.next;
            slow = slow.next;
        }
        //将倒数第k+1个节点和倒数第k个节点分开
        ListNode newHead = slow.next;//新的头是倒数第k个节点
        slow.next = null;
        fast.next = head;
        return newHead;

    }
}
