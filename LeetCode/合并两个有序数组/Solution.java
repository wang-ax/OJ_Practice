/**
 * ClassName PACKAGE_NAME
 * Description TODO
 * Author 30712
 * Date 2021-04-05
 * Time 22:14
 */
public class Solution {
        //m和n分别为nums1和nums2初始化的数量
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //合并两个有序数组，将nums2合并到nums1中，使nums1成为一个有序数组
            int[] newArray = new int[m+n];
            int i=0;
            int j =0;
            int k =0;
            while (i < m && j < n){
                if (nums1[i] < nums2[j]){
                    newArray[k++] = nums1[i++];
                }else {
                    newArray[k++] = nums2[j++];
                }
            }
            //如果第一个数组遍历完，直接将第二个数组元素放入新数组
            if ( i >= m){
                while (j <n){
                    newArray[k++] = nums2[j++];
                }
            }
            if (j <= n){
                while (i < m){
                    newArray[k++] = nums1[i++];
                }
            }
            //最终要使nums1成为有序数组，所以将数组中的元素赋给nums1
            //将数组中的元素，依次赋给nums1
            for (int l = 0;l < newArray.length;l++){
                nums1[l] = newArray[l];
            }
        }

    public static void main(String[] args) {
        Solution solution= new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        solution.merge(nums1,m,nums2,n);
        for (int  i : nums1){
            System.out.println(i);
        }
    }
}
