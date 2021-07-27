package p07.p_0727.二叉树的第二小节点;

/**
 * ClassName p07.p_0727.二叉树的第二小节点
 * Description TODO
 * Author 30712
 * Date 2021-07-27
 * Time 9:08
 */

/**
 * 如果有一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个
 * 对于二叉树中的任意节点x，x的值不大于其所有的子节点的值
 * 二叉树根节点的值即为所有节点中的最小值
 *  对整颗二叉树进行一次遍历，设根结点的值为rootValue，只需要通过遍历，找出严格大于rootValue的最小值，即为所有节点中的第二小的值
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
    int res;
    int rootValue;
    public int findSecondMinimumValue(TreeNode root) {
        res =-1;
        rootValue = root.val;
        dfs(root);
        return res;
    }

    //深度遍历
    private void dfs(TreeNode node) {
        if (node == null){
            return;
        }
        if (res != -1 && node.val >=res){
            return;
        }
        if (node.val > rootValue){
            res = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
