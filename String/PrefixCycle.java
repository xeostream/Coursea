/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package String;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class PrefixCycle {
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int cnt = 1;
            int len = Integer.parseInt(scan.nextLine());
            if (len == 0) return ;
            String str = scan.nextLine();
            int[] nums = new int[len];
            nums[1] = (str.charAt(0)==str.charAt(1) ? 1 : 0);
            for (int i = 2; i < len; i++) {
                for (int j = 1; j <= i; j += 2) {
                    if ((i+1) % j != 0) continue;
                    String s = str.substring(0, j);
                    if (str.replaceAll(s, "").equals(""))
                        nums[i] = j;
                }
            }
            System.out.println("Test case #" + cnt++);
            for (int i = 1; i < len; i++) {
                if (nums[i] > 0) {
                    int j = i + 1;
                    int in = j / nums[i];
                    System.out.println(j + " " + in);
                }
            }
            System.out.println();
        }
    }
}
