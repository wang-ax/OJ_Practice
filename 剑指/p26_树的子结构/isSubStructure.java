package p_0626;

/**
 * ClassName p_0626
 * Description TODO 树的子结构
 * Author 30712
 * Date 2021-06-26
 * Time 10:42
 */
class  TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class isSubStructure {
    /**
     *判断B树是不是A树的子结构
     * @param A
     * @param B
     * @return
     *1.先序遍历树A中的每一个节点NA      isSubStructure(A,B)
     * 2.判断树A中以NA为根结点的子树是否包含树B   recur(A,B)
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null){
            return false;
        }
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
