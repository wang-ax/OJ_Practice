package 二叉搜索树迭代器;


import java.util.ArrayList;
import java.util.List;

/**
 * ClassName 二叉搜索树迭代器
 * Description TODO
 * Author 30712
 * Date 2021-03-28
 * Time 19:10
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
//二叉搜索树的中序遍历是有序的
public class BSTIterator {
   /* private TreeNode current;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        //初始化为一个不存在于BST中的数字，且该数字晓宇BST中的任何元素
        current = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (current != null){
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        int ret = current.val;
        current = current.right;
        return ret;
    }

    public boolean hasNext() {
        return current!= null || !stack.isEmpty();
    }*/

    private  int index ;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        index = 0;
        arr = new ArrayList<Integer>();
        inorderTraversal(root, arr);
    }

    public int next() {
        return arr.get(index++);
    }

    public boolean hasNext() {
        return index < arr.size();
    }
    //中序遍历搜索二叉树
    //得到的数组是有序的
    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
}
