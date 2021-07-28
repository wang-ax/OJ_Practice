package p07.p_0728.二叉树中所有距离为K的结点;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName p07.p_0728.二叉树中所有距离为K的结点
 * Description TODO
 * Author 30712
 * Date 2021-07-28
 * Time 8:52
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
    /**
     * 深度优先搜索+哈希表
     * 时间复杂度：O(n),需要执行两次深度优先搜索，每次的时间复杂度为O(n)
     * 空间复杂度：O(n),记录父节点需要O(n)的空间，深度优先搜索需要O(n)的栈空间
     */
    Map<Integer,TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root,TreeNode target,int k){
       //从root出发，深度遍历，记录每个结点的父结点
        findParents(root);
        //从target出发深度遍历，寻找所有深度为K的结点
        findAns (target,null,0,k);
        return ans;
    }

    private void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null){
            return;
        }
        if (depth == k){
            ans.add(node.val);
            return;
        }
        if (node.left != from){
            findAns(node.left,node,depth+1,k);
        }
        if (node.right != from){
            findAns(node.right,node,depth+1,k);
        }
        if (parents.get(node.val) != from){
            findAns(parents.get(node.val),node,depth+1,k);
        }
    }

    public void findParents(TreeNode node){
        if (node.left != null){
            parents.put(node.left.val,node);
            findParents(node.left);
        }
        if (node.right != null){
            parents.put(node.right.val,node);
            findParents(node.right);
        }
    }
}
