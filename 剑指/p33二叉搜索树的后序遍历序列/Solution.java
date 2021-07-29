package p33二叉搜索树的后序遍历序列;

/**
 * ClassName p33二叉搜索树的后序遍历序列
 * Description TODO 判断给出的序列是不是二叉搜索树的后序遍历序列
 * Author 30712
 * Date 2021-06-05
 * Time 16:34
 */

/**
 * 二叉搜索树的性质：中序遍历是有序的，左子树的所有节点的值小于根节点的值，右子树中所有节点的值大于根节点的值
 * 后序遍历：左右根
 * 数组的最后一个即为二叉树的根节点
 */
class Solution{
    public static boolean verifyPostorder(int[] sequence) {
        if (sequence == null || sequence.length <= 0)
            return true;
        return verifyCore(sequence, 0, sequence.length - 1);
    }
    public static boolean verifyCore(int[] sequence, int start, int end) {
        if (start >= end){//该子树的节点数量<=1 ,直接返回true
            return true;
        }
        //判断左子树
        //从左网友找出第一个比根结点大的值，它前面的都是根结点的左子树的节点
        //它后面的都是根结点的右子树的节点（包含当前值，不包含最后一个值，因为最后一个是根结点）
        int mid = start;
        while (sequence[mid] < sequence[end]){
            mid++;
        }

        //判断右子树
        for (int i = mid; i < end; i++) {
            if (sequence[i] < sequence[end])
                return false;
        }

        //判断左子树和右子树是否满足
        return verifyCore(sequence, start, mid - 1) &&
                verifyCore(sequence, mid, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,6,5};
        System.out.println(verifyPostorder(arr));
    }
}

