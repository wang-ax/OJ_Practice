<<<<<<< HEAD
package p34二叉树中和为某一值的路径;

/**
 * ClassName p34二叉树中和为某一值的路径
 * Description TODO
 * Author 30712
 * Date 2021-06-05
 * Time 17:05
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    List<List<Integer>> listAll = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null){
            return listAll;
        }
        list.add(root.val);  // 先将根节点加入路径集合中
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            // target等于0，并且当前节点是叶子节点，则说明该路径符合条件
            listAll.add(new ArrayList<Integer>(list));
        }

        pathSum(root.left, target);  // 左子树迭代查找
        pathSum(root.right, target); // 右子树迭代查找
        // 如果当前路径已经到了叶子节点也不符合条件，则退回其父节点
        // 深度遍历完一条路径后要回退：将list中最后一个节点删除
        list.remove(list.size() - 1);
        return listAll;
    }
=======
package p34二叉树中和为某一值的路径;

/**
 * ClassName p34二叉树中和为某一值的路径
 * Description TODO
 * Author 30712
 * Date 2021-06-05
 * Time 17:05
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    List<List<Integer>> listAll = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null){
            return listAll;
        }
        list.add(root.val);  // 先将根节点加入路径集合中
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            // target等于0，并且当前节点是叶子节点，则说明该路径符合条件
            listAll.add(new ArrayList<Integer>(list));
        }

        pathSum(root.left, target);  // 左子树迭代查找
        pathSum(root.right, target); // 右子树迭代查找
        // 如果当前路径已经到了叶子节点也不符合条件，则退回其父节点
        // 深度遍历完一条路径后要回退：将list中最后一个节点删除
        list.remove(list.size() - 1);
        return listAll;
    }
>>>>>>> a83a4245b9afe6fe44822877ca200b9610f46471
}