package p_0620;

/**
 * ClassName p_0620
 * Description TODO
 * Author 30712
 * Date 2021-06-20
 * Time 16:19
 */
public class maxArea {
    public static int maxArea(int[] height){
        /**
         * 时间复杂度：O(n^2)
         * 控件复杂度：O(1)
         */
 /*       int max =0;
        for (int i=0;i< height.length;i++){
            for (int j=i+1;j<height.length;j++){
                max = Math.max(max,Math.min(height[i],height[j])*(j-i));
            }
        }
        return max;*/

        /**
         * 双指针
         * 如何移动指针？
         * 相同情况下两边的距离越远越好
         * 区域受限于较短的边
         * 时间复杂度：O(n)
         * 控件复杂度：O(1)
         */
        int max =0;
        //双指针初始值为数组的两端
        int left =0;
        int right = height.length-1;
        while (left < right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left] < height[right]){//向内移动较短边
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
