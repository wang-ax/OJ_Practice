package 红与黑;

import java.util.Scanner;

/**
 * ClassName 红与黑
 * Description TODO
 * Author 30712
 * Date 2021-03-10
 * Time 8:18
 */
public class Main{
    static char [][]g = new char[30][30];
    static int []dx = {-1,0,1,0};
    static int []dy = {0,1,0,-1};
    static int n,m,x,y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            m = sc.nextInt();//行
            n = sc.nextInt();//列
            if(n == 0 && m == 0) {
                return;
            }
            for(int i = 0;i < m;i ++) {
                String s = sc.next();
                g[i] = s.toCharArray();
                for(int j = 0;j < n;j ++) {
                    if(g[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(  dfs(x,y));
        }

    }
    static int dfs(int x,int y) {
       int res =1;
        for(int i = 0;i < 4;i ++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a >= 0 && a < m && b >= 0 && b < n && g[a][b] == '.') {
                res += dfs(a,b);
            }
        }
        return res;
    }
}