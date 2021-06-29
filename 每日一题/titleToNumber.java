package p_0629;

/**
 * ClassName p_0629
 * Description TODO
 * Author 30712
 * Date 2021-06-29
 * Time 15:25
 */
public class titleToNumber {
    public static int titleToNumber(String columnTitle){
        char[] chars = columnTitle.toCharArray();
        int result =0;
        for (int i=0;i< chars.length;i++){
            //chars[i]-'A'+1
            result = result*26+(chars[i]-'A'+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String  col = "AA";
        System.out.println(titleToNumber(col));
    }
}
