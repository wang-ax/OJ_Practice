package 求和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName 求和
 * Description TODO
 * Author 30712
 * Date 2021-03-16
 * Time 15:59
 */
public class Main {
    static List<Integer> temp=new ArrayList<Integer>();
    static int sum=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();//从1到n
            int m = scanner.nextInt();//和为m的数列出来，按照字典序
            dfs(m,n,1);//深度遍历
            sum =0;
        }
    }
    public static void dfs(int M,int N,int pos){
        if(sum>M || pos>N+1){
            return ;
        }else if(sum==M){
            for(int i=0;i<temp.size();i++){
                if(i==0){
                    System.out.print(temp.get(i));
                }else{
                    System.out.print(" "+temp.get(i));
                }
            }
            System.out.println();
        }else{
            sum+=pos;
            temp.add(pos);
            dfs(M,N,pos+1);
            sum-=pos;
            temp.remove(temp.size()-1);
            dfs(M,N,pos+1);
        }
    }
}
