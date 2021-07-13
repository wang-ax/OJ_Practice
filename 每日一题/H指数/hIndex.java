package p07.p_0713;

import java.util.Arrays;

/**
 * ClassName p07.p_0713
 * Description TODO
 * Author 30712
 * Date 2021-07-13
 * Time 15:36
 */
public class hIndex {
    public  int hIndex(int[] citations){
        Arrays.sort(citations);
        //0,1,3,5,6
/*        int n = citations.length;
        //h 篇论文分别被引用了至少h次
        int h =0;
        int i = n-1;
        while (i >=0 && citations[i] > h){
            h++;
            i--;
        }
        return h;*/


        int n = citations.length;
        int left =0;
        int right = citations.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (citations[mid] >= n-mid){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return n-left;
    }

    public static void main(String[] args) {
        int[] citations ={ 3,0,6,1,5};
       // int[] citations = {0};
        hIndex h = new hIndex();
        System.out.println(h.hIndex(citations));
    }
}
