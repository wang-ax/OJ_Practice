package p37序列化二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName p37序列化二叉树
 * Description TODO
 * Author 30712
 * Date 2021-06-30
 * Time 17:14
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class Codec {
    public String serialize(TreeNode root) {
        //二叉树进行层序遍历
        if (root == null){
            return "[]";
        }
        StringBuilder data = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode current;
        while (!queue.isEmpty()){
            current = queue.poll();
            if (current != null){
                data.append(current.val+",")  ;
                queue.add(current.left);
                queue.add(current.right);
            }else {
                data.append("null,");
            }
        }
        data.deleteCharAt(data.length()-1);
        data.append("]");
        return data.toString();
    }
    public TreeNode deserialize(String data){
        if (data.equals("[]")){
            return null;
        }
        //先去掉首尾的中括号，再用逗号隔开
        String[] strings = data.substring(1,data.length()-1).split(",");
        //先构建根结点
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!strings[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.left);
            }
            i++;
            if (strings[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
