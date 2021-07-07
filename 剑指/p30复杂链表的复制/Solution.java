package p30复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName p30复杂链表的复制
 * Description TODO
 * Author 30712
 * Date 2021-07-07
 * Time 15:43
 */
class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
public class Solution {
    /**
     * 时间复杂度：O（N）
     * 空间复杂度：O(N)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while (cur != null){
            //复制各结点，建立”原结点——>新节点的映射关系“
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //构建新链表的next和random的指向
        while (cur != null){

            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回链表的头结点
        return map.get(head);
    }

    /**
     * 时间复杂度：O（n） 遍历了3边链表
     * 空间复杂度：O(1) 结点引用变量使用常数大小的额外空间
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head){
        if (head == null){
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
        return res;//5.返回的是新链表的头结点
    }
}
