/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        //中序遍历
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);

        //构建新的递增顺序搜索树
        TreeNode newNode = new TreeNode(-1);
        //TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = newNode;
        for (int value : list) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return newNode.right;
    }
    //递归进行中序遍历
    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}