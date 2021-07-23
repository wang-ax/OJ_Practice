package p52两个链表的第一个公共节点;

/**
 * ClassName p52两个链表的第一个公共节点
 * Description TODO
 * Author 30712
 * Date 2021-06-07
 * Time 21:15
 */
class ListNode {
    int val;
    ListNode next;
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //两个链表的第一个公共节点
        int lenA =0;
        int lenB =0;
        ListNode pl= headA;
        ListNode ps = headB;
        while(pl != null){
            pl = pl.next;
            lenA++;
        }
        while(ps != null){
            ps = ps.next;
            lenB++;
        }
        //pl和ps都已经为空了
        pl = headA;
        ps = headB;
        while (lenA != lenB) {
            if (lenA > lenB) {
                //如果链表A长，那么链表A先走
                pl = pl.next;
                lenA--;
            } else {
                //如果链表B长，那么链表B先走
                ps = ps.next;
                lenB--;
            }
        }
        //然后开始比较，如果他俩不相等就一直往下走
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }
}
