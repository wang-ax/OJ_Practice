package 不同的二叉搜索树;



import java.util.LinkedList;
import java.util.List;

/**
 * ClassName 不同的二叉搜索树
 * Description TODO
 * Author 30712
 * Date 2021-03-28
 * Time 19:52
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
    public List<TreeNode> generateTrees(int n) {
        //生成由1-n组成地所有的二叉搜索树
        if (n == 0){
            return  new LinkedList<>();
        }
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end){
            list.add(null);
            return list;
        }
        //列举可行的根结点
        for (int i = start;i<= end;i++){
            //获得所有可行的左子树的集合
            List<TreeNode> leftTree = generateTrees(start,i-1);
            //获得所有的可行的右子树的集合
            List<TreeNode> rightTree = generateTrees(i+1,end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left :leftTree){
                for (TreeNode right : rightTree){
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    list.add(currentTree);
                }
            }
        }
        return list;
    }
}
