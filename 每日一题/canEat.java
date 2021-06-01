/**
 * ClassName PACKAGE_NAME
 * Description TODO
 * Author 30712
 * Date 2021-06-01
 * Time 15:12
 */

/**
 *
 * queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 * 每天至少吃一颗糖,最多吃dailyCapi颗糖
 * 必须按照顺序吃糖，0类型的糖吃完了才能吃1类型的糖，以此类推
 * 从第0天开始吃糖
 */
public class canEat {
    /**
     * candiesCount
     * @param candiesCount 数组中存储的是每一类糖的个数
     * @param queries  是一个二维数组，queries[i]=[favouriteType,favouriteDay,dailyCap]
     *                 最喜欢的糖果类型,最喜欢的那天,每天最多吃的糖果数
     * @return
     */
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        // 前缀和
        //sum[i]表示的是前i天的糖果的个数
        long[] sum = new long[n];//记录糖果数量的前缀和，记录在数组sum中
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];

        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

            //我们吃的糖果的数量落在的区间：（最少每天吃1个，最多每天吃dailyCap个）
            //[favoriteDay + 1,(favoriteDay + 1) * dailyCap]

            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;

            //第favoriteType种类型的糖果对应的编号范围为：[sum[favoriteType-1]+1,sum[favoriteType]]
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;

            long y2 = sum[favoriteType];

            //判断两个区间是否有交集
            //如果有交集，说明可以吃到favoriteType类的糖果
            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] candiesCount = {7,4,5,3,8};
        int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};
        boolean[] result  = canEat(candiesCount, queries);
        for (boolean b : result){
            System.out.println(b);
        }
    }
}
