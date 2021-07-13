package p07.p_0713;

/**
 * ClassName p07.p_0713
 * Description TODO
 * Author 30712
 * Date 2021-07-13
 * Time 16:21
 */
public class hIndex2 {
    public int hIndex2(int[] citations){
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
        int[] citations = {0,1,3,5,6};
        hIndex2 h = new hIndex2();
        System.out.println(h.hIndex2(citations));
    }
}
