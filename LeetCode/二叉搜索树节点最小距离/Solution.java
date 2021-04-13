package 二叉搜索树节点最小距离;


import java.util.ArrayList;
import java.util.List;

/**
 * ClassName 二叉搜索树节点最小距离
 * Description TODO
 * Author 30712
 * Date 2021-04-13
 * Time 22:20
 */
class TreeNode {
    int val;
    TreeNode  left;
    TreeNode  right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    //二叉搜索树的中序遍历是有序的
    public static int minDiffInBST(TreeNode root) {
        //树中任意两个不同结点值之间的最小差值
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return -1;
        }
        inOrder(root,list);
        //得到中序遍历的结果
        if (list.size() == 0){
            return -1;
        }

        int res = Integer.MAX_VALUE;
        int pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i)-pre);
            pre = list.get(i);
        }
        return res;


    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        //先得到中序遍历的结果
        if (root == null){
            return;
        }
        if (root.left != null){
            inOrder(root.left,list);
        }
        list.add(root.val);
        if (root.right != null){
            inOrder(root.right,list);
        }
    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(4);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(6);
        TreeNode t4=new TreeNode(1);
        TreeNode t5=new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        int num = minDiffInBST(t1);
        System.out.println(num);

    }
}
