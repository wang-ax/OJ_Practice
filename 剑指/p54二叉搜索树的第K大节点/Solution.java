package p54二叉搜索树的第K大节点;


import java.util.ArrayList;
import java.util.List;

/**
 * ClassName p54二叉搜索树的第K大节点
 * Description TODO
 * Author 30712
 * Date 2021-06-10
 * Time 10:11
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public static List<Integer>  res = new ArrayList<>();
    public int KthLargest(TreeNode root,int k){
        inOrder(root);
        //在ArrayList种找到第k大的数字
        return res.get(res.size()-k);//中序遍历是从小到大的顺序，需要从后往前数第K个数字
    }
    void inOrder (TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
}
