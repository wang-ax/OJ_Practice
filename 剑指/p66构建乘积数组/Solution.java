package p66构建乘积数组;

/**
 * ClassName p66构建乘积数组
 * Description TODO
 * Author 30712
 * Date 2021-07-03
 * Time 16:46
 */
public class Solution {
    public int[] constructArr2(int[] a){
        if (a.length == 0){
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0]=1;//初始化b[0]=1
        int temp=1;
        //计算下三角的乘积
        for (int i=1;i< a.length;i++){
            b[i] = b[i-1]*a[i-1];
        }
        //计算上三角的乘积
        for (int i=a.length-2;i>=0;i--){
            temp *= a[i+1];
            b[i] *= temp;
        }
        return b;
    }
    public  int[] constructArr(int[] a){
        if (a == null || a.length == 0){
            return a;
        }
        int length = a.length;
        int[] resLeft = new int[length];
        int[] resRight = new int[length];
        resLeft[0]=1;
        resRight[length-1] =1;

        //当前元素左边的所有元素的乘积（不包含当前元素）
        for (int i=1;i< length;i++){
            resLeft[i] = resLeft[i-1] * a[i-1];
        }
        //当前元素右边的所有元素的乘积（不包含当前的元素）
        for (int i= length-2;i>=0;i--){
            resRight[i] = resRight[i+1] * a[i+1];
        }
        //左边乘以右边就是要得到的结果
        int[] res = new int[length];
        for (int i=0;i< length;i++){
            res[i] = resLeft[i]* resRight[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1,2,3,4,5};
        int[] res = solution.constructArr(array);
        for (int i : res){
            System.out.println(i);
        }
    }
}

