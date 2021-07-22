package p07.p_0722.复制带随机指针的链表;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName p07.p_0722.复制带随机指针的链表
 * Description TODO
 * Author 30712
 * Date 2021-07-22
 * Time 9:08
 */
class  Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
    }
}
public class Solution {
    /**
     * 复制带随机指针的链表
     * @param head
     * @return
     */
    public Node copyRandomList(Node head){

     /*   if (head == null){
            return head;
        }
        //复制节点，直接插入到本身节点的后面
        Node pNode = head;
        while (pNode != null){
            Node copyNode = new Node(pNode.val);
            copyNode.next = pNode.next;
            pNode.next = copyNode;
            pNode = pNode.next.next;
        }
        //连接新的随机指针
        Node newpNode = head.next;
        pNode = head;
        while (newpNode.next != null){
            if (pNode.random != null){
                newpNode.random = pNode.random.next;
            }
            pNode = pNode.next.next;
            newpNode = newpNode.next.next;
        }
        if (pNode.random != null){
            newpNode.random = pNode.random.next;
        }
        //分离链表
        Node ans = new Node(-1);
        Node pans = ans;
        pNode = head;
        while (pNode != null){
            pans.next = pNode.next;
            pans = pans.next;
            pNode.next = pans.next;
            pNode = pNode.next;
        }
        return ans.next;*/

        /**
         * 使用了map用来保存旧节点的新节点，空间复杂度O(n)
         */
        if(head == null){
            return head;
        }
        Node cur = head;
        Map<Node,Node> map  = new HashMap<>();
        //复制节点
        while (cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //构建新链表的next和random的指向
        while (cur != null){
            //新节点的next就是旧节点的next
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);



       /* if (head == null){
            return null;
        }
        Node cur = head;
        //1.复制结点，构建拼接链表
        while (cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        //2.构建新结点的random指向
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.拆分链表
        cur = head.next;
        Node pre = head;
        Node res = head.next;
        while (cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        //4.处理原链表的尾结点
        pre.next = null;
        return res;//5.返回的是新链表的头结点*/
    }
}
