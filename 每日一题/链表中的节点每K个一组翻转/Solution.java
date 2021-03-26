package 链表中的节点每K个一组翻转;


/**
 * ClassName 链表中的节点每K个一组翻转
 * Description TODO
 * Author 30712
 * Date 2021-03-26
 * Time 13:38
 */

public class Solution {
    private class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        //链表中每K 个节点进行反转
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode end = newHead;
        while (end.next != null){
            for (int i =0;i<k&& end!= null;i++){
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            prev.next = reverse(start);

            start.next = next;
            prev = start;
            end = prev;
        }
        return newHead.next;
    }

    public ListNode reverse(ListNode head){
        //翻转链表
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current!= null && next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        return current;

        /*ListNode newHead = null;
        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode currentNext = current.next;
            if(currentNext == null) {
                newHead = current;
            }

            current.next = prev;
            prev = current;
            current = currentNext;
        }
        return newHead;*/
    }
}
