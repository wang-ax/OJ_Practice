package p36二叉搜索树与双向循环链表;

/**
 * ClassName p36二叉搜索树与双向循环链表
 * Description TODO
 * Author 30712
 * Date 2021-08-14
 * Time 19:07
 */
class Node{
    public int val;
    public  Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}
public class Solution {
    Node prev;//当前结点的前一个结点
    Node head;//记录头结点
    public Node treeToDoublyList(Node root) {
        //二叉搜索树的中序遍历是有序的
        if (root == null){
            return null;
        }
        dfs(root);

        head.left = prev;
        prev.right = head;//头尾结点的相互指向，连成循环链表

        return head;
    }

    //二叉树的中序遍历
    private void dfs(Node root) {
        if (root == null){
            return;
        }
        //先遍历左子节点
        dfs(root.left);

        //对当前结点进行操作
        if (prev != null){
            prev.right = root;
        }else {
            head = root;//current的左侧没有结点，current就是head结点
        }
        //前一个结点和当前结点串起来
        root.left = prev;
        //当前结点变成前一个结点
        prev = root;//prev指向当前的current

        //遍历右子节点
        dfs(root.right);
    }

}
