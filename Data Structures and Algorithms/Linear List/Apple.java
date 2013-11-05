
import java.util.Scanner;

/**
 * Question: http://dsalgo.openjudge.cn/dsmoochw2/4/
 * @author Arthur
 */
public class Apple {
    public static int dp(int i, int j) {
        if (i == 0 || j == 1)
            return 1;
        if (i >= j)
            return dp(i - j, j) + dp(i, j - 1);
        else
            return dp(i, i);
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int t, M, N;
        t = scan.nextInt();
        while (t-- > 0) {
            M = scan.nextInt();
            N = scan.nextInt();
            System.out.println(dp(M, N));
        }
        scan.close();
    }
}
