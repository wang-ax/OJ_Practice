package 重建二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName 重建二叉树
 * Description TODO
 * Author 30712
 * Date 2021-04-21
 * Time 21:30
 */
class  TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = inArrayToList(preorder);
        List<Integer> inorderList = inArrayToList(inorder);

        return buildTreeInternal(preorderList,inorderList);

    }

    private TreeNode buildTreeInternal(List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.isEmpty()){
            return null;
        }
        int rootVal = preorderList.get(0);//第一个元素就是根结点的值
        TreeNode root = new TreeNode(rootVal);//构建根结点
        if (preorderList.size() == 1){
            return root;
        }
        int leftSize = inorderList.indexOf(rootVal);
        //左子树的前序和右子树的前序
        List<Integer> leftPre = preorderList.subList(1,1+leftSize);
        List<Integer> rightPre = preorderList.subList(1+leftSize,preorderList.size());

        //左子树的中序遍历和右子树的中序遍历
        List<Integer> leftIn = inorderList.subList(0,leftSize);
        List<Integer> rightIn = inorderList.subList(leftSize+1,inorderList.size());

        //分别进行创建左子树和右子树
        root.left = buildTreeInternal(leftPre,leftIn);
        root.right = buildTreeInternal(rightPre,rightIn);
        return root;
    }

    //数组转为List
    private List<Integer> inArrayToList(int[] array) {
        List<Integer>  list = new ArrayList<>();
        for (int e : array){
            list.add(e);
        }
        return list;
    }
}
