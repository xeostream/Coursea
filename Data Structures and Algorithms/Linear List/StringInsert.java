
import java.util.Scanner;

/**
 * Question: http://dsalgo.openjudge.cn/dsmoochw2/2/
 * @author Arthur
 */
public class StringInsert {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        while (!str.equals("")) {
            String[] list = str.split(" ");
            StringBuilder str1 = new StringBuilder(list[0]);
            String str2 = list[1];
            int index = 0;
            for (int i = 1; i < str1.length(); i++) {
                if (str1.charAt(index) < str1.charAt(i)) {
                    index = i;
                }
            }
            str1.insert(index + 1, str2);
            System.out.println(str1);
            str = scan.nextLine();
        }
    }
}
