package 删除公共字符;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * ClassName 删除公共字符
 * Description TODO
 * Author 30712
 * Date 2021-03-13
 * Time 8:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String originalString = scanner.nextLine();
            String s2= scanner.nextLine();
            System.out.println(deletePublicString(originalString, s2));
        }
    }

    private static String deletePublicString(String originalString, String s2) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeSet<Character> set = new TreeSet<>();
        for (Character character : s2.toCharArray()){
            set.add(character);
        }
        for (int i =0;i<originalString.length();i++){
            char c = originalString.charAt(i);
            if (!set.contains(c)){
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
