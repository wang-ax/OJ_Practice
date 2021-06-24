package p_0624;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName p_0624
 * Description TODO
 * Author 30712
 * Date 2021-06-24
 * Time 19:57
 */
class Point{
    int x;
    int y;
    public Point(){
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class maxPoints {
    public int maxPoints(int[][] points) {
        //最多有多少个点在同一条直线上
        //有多少个点的斜率是相同的，斜率相同的点就在同一条直线上
        //选定一个点，分别计算其他点和它构成的直线的斜率，斜率相同的点肯定在同一条直线上。
        /**
         * 定义一个HashMap：
         * key：斜率
         * value：在该斜率下在同一条直线上有多少个点
         */
        int result = 1;
        for (int i = 0; i < points.length; i++) {
            double x1 = points[i][0];
            double y1 = points[i][1];
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                double x2 = points[j][0];
                double y2 = points[j][1];
                double k = 0.0;
                if (x1 == x2) {
                    k = 1;
                } else if (y1 == y2) {

                } else {
                    k = (y2 - y1) / (x2 - x1);
                }
                int num = map.getOrDefault(k, 1);
                map.put(k, num + 1);
                result = Math.max(result, num + 1);
            }
        }
        return result;
    }
}