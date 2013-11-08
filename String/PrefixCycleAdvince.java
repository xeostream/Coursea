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
public class PrefixCycleAdvince {
    public static void getNext(int[] next, String str) {
        int length = str.length();
        int i = 1, j = 0;
        next[0] = -1;
        while (i < length) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
                  j = next[j]; 
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = 1;
        while (true) {
            int len = Integer.parseInt(scan.nextLine());
            if (len == 0) return ;
            int[] next = new int[len+1];
            String str = scan.nextLine();
            getNext(next, str);
            System.out.println("Test case #" + (cnt++));
            for (int i = 1; i <= str.length(); i++) {
                int temp = i - next[i];
                if (i % temp == 0 && i / temp > 1)
                    System.out.println(i + " " + i / temp);
            }
            System.out.println();
        }
    }
}
