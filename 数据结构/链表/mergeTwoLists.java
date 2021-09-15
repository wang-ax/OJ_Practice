package lianbiao;

/**
 * ClassName lianbiao
 * Description TODO 合并两个有序的链表
 * Author 30712
 * Date 2021-09-14
 * Time 12:32
 */
public class mergeTwoLists {
    public static ListNode mergeTwoLists (ListNode headA,ListNode headB){
        if (headA == null && headB == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        //合并两个有序的链表
        while (headA != null && headB != null){
            if(headA.val  < headB.val){
                temp.next= headA;
                temp = temp.next;
                headA = headA.next;
            }else {
                temp.next = headB;
                temp = temp.next;
                headB = headB.next;
            }
        }
        //其中一个链表中没有数据
        if (headA == null){
            temp.next = headB;
        }
        if (headB == null){
            temp.next = headA;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        //创建两个链表
        ListNode headA = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(4);
        headA.next = h1;
        h1.next = h2;

        ListNode headB = new ListNode(1);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        headB.next = h3;
        h3.next = h4;

        mergeTwoLists(headA, headB);
    }
}
