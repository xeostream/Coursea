
import java.util.Scanner;

/**
 * Question: http://dsalgo.openjudge.cn/dsmoochw2/3/
 * @author Arthur
 */
public class Bit {
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int cnt = scan.nextInt();
        int[] data = new int[len];
        for (int i = 0; i < data.length; i++)
            data[i] = scan.nextInt() % 65536;
        for (int i = 0; i < cnt; i++) {
            String str = scan.next();
            int num = scan.nextInt();
            if (str.equals("C"))
                for (int j = 0; j < data.length; j++)
                    data[j] = (data[j] + num) % 65536;
            if (str.equals("Q")) {
                int result = 0;
                for (int in : data)
                    if (((in >> num) & 1) == 1)
                        result++;
                System.out.println(result);
            }
        }
    }
}
