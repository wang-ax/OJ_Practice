package 判断一颗二叉树是否为搜索二叉树和完全二叉树;




import java.util.*;

/**
 * ClassName 判断一颗二叉树是否为搜索二叉树和完全二叉树
 * Description TODO
 * Author 30712
 * Date 2021-03-14
 * Time 9:36
 */
class  TreeNode {
    public  int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean[] result = new boolean[2];
        //判断是不是搜索二叉树
        result[0] = isBinarySearchTree(root);
        //判断是不是完全二叉树
        result[1] = isCompleteBinaryTree(root);
        return result;
    }

    private boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null){
            return true;
        }
        //层序遍历二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current != null){
                queue.offer(current.left);
                queue.offer(current.right);
            }else {
                while (!queue.isEmpty()){
                    TreeNode cur = queue.poll();
                    if (cur != null){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBinarySearchTree(TreeNode root){
        //判断是不是二叉搜索树
        if(root == null){
            return true;
        }
        if (root.left != null &&(root.left.val > root.val || !isBinarySearchTree(root.left))){
            return false;
        }
        if (root.right != null && (root.right.val < root.val || !isBinarySearchTree(root.right))){
            return false;
        }
        return true;
//        //中序遍历
//        List<Integer> list = inOrder(root);
//        //判断list是不是有序的
//        for(int i = 1; i < list.size(); i++) {
//            if(list.get(i) <= list.get(i - 1)) {
//                return false;
//            }
//        }
//        return true;
    }
//    public List<Integer> inOrder( TreeNode root){
//        List<Integer> list = new ArrayList<>();
//        if(root == null){
//            return null;
//        }else{
//            inOrder(root.left);
//            list.add(root.val);
//            inOrder(root.right);
//        }
//        return list;
//    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.judgeIt(root)));
    }
}
