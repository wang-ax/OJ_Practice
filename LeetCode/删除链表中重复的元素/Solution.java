package 删除数组中重复元素;


/**
 * ClassName 删除数组中重复元素
 * Description TODO
 * Author 30712
 * Date 2021-03-26
 * Time 13:38
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //不会删除头节点
        ListNode current = head;
        while(current.next!= null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }

    private class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
