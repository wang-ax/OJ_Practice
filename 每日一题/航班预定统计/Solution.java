package p08.p_0831.航班预定统计;

/**
 * ClassName p08.p_0831.航班预定统计
 * Description TODO
 * Author 30712
 * Date 2021-08-31
 * Time 17:17
 */
public class Solution {
    /**
     *
     * @param bookings 航班预定表
     *                表中第 i 条预订记录 bookings[i] = [first i, last i, seats i]
     *                意味着在从 first i 到 last i  （包含 first i 和 last i ）
     *                的 每个航班 上预订了 seats i 个座位。
     * @param n n个航班，分别从1-n进行编号
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings){
            result[booking[0]-1] +=booking[2];
            if (booking[1] < n){
                result[booking[1]] -=booking[2];
            }
        }
        for (int i=1;i<n;i++){
            result[i] +=result[i-1];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        int[] ints = s.corpFlightBookings(bookings, n);
        for (int i : ints){
            System.out.println(i);
        }
    }
}
