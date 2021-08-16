package p08.p_0815.快速排序;

/**
 * ClassName p08.p_0815.快速排序
 * Description TODO
 * Author 30712
 * Date 2021-08-15
 * Time 22:43
 */
public class Solution {
    /**
     * 快速排序是原地排序算法，内部元素进行交换，不稳定的算法
     * 时间复杂度：最坏——数组是有序的,极端情况下会是O(n^2)
     *          最好——O(nlogn),每次Partition划分的都是很均匀的
     *          平均——O(nlogn)
     * @param array
     */
    //从要排序的区间中选择一个数作为基准数key
    public void quickSort(int[] array){
        quickInternal(array,0,array.length-1);
    }

    private void quickInternal(int[] array, int left, int right) {
        if (left == right){
            return;
        }
        if (left > right){
            return;
        }

        int keyIndex = partition(array,left,right);
        quickInternal(array,left,keyIndex-1);
        quickInternal(array,keyIndex+1,right);
    }
    //挖坑法
    private  int partition(int[] array,int left ,int right){
        int key = array[left];
        int i =left;
        int j = right;
        while (i < j){
            while (i < j && array[j] >= key){
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= key){
                i++;
            }
            array[j] = array[i];
        }
        array[i] = key;
        return i;
    }
    /*private int partition(int[] array, int left, int right) {
        int key = array[left];
        int i=left,j=right;
        while (i < j){
            while (i < j && array[j] >=key){
                j--;
            }
            while (i < j && array[i] <= key){
                i++;
            }
        }
        swap(array,i,left);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int p = array[i];
        array[i] = array[j];
        array[j] = p;
    }*/


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        Solution s = new Solution();
        s.quickSort(array);
        for (int m : array){
            System.out.println(m);
        }
    }
}
