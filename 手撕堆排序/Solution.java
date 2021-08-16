package p08.p_0815.手撕堆排序;

/**
 * ClassName p08.p_0815.手撕堆排序
 * 堆排序是选择排序的变形，基本的原理是选择排序，使用堆来查找无序区间的最大值
 * Description TODO
 * Author 30712
 * Date 2021-08-16
 * Time 7:59
 */
public class Solution {
    //堆排序
    public void heapSort(int[] array){
        creatHeap(array,array.length);
        for (int i=0;i< array.length-1;i++){
            //
            swap(array,0,array.length-i-1);
            //向下调整
            shiftDown(array,array.length-i-1,0);
        }

    }

    private void creatHeap(int[] array, int length) {
        //从最后一个非叶子结点进行调整
        for (int i = (length-1)/2;i>=0 ;i--){
            shiftDown(array,array.length,i);
        }
    }

    private void shiftDown(int[] array, int size, int index) {
        int left = 2*index+1;
        while ( left < size){
            int maxIndex = left;
            if (maxIndex+1 < size && array[maxIndex+1] > array[maxIndex]){
                maxIndex = maxIndex+1;
            }
            if (array[index] >= array[maxIndex]){
                break;
            }
            swap(array,index ,maxIndex);
            index = maxIndex;
            left = 2*index+1;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] array = {1,2,3,4,5};
        int[] array = {5,7,4,3,2,1};
        s.heapSort(array);
        for (int a : array){
            System.out.println(a);
        }
    }
}
