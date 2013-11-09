/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class AncientPassword {

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        String now = scan.nextLine();
        String origin = scan.nextLine();
        int len = now.length();
        int[] n = new int[26];
        int[] o = new int[26];
        for (int i = 0; i < len; i++) {
            n[now.charAt(i)-'A']++;
            o[origin.charAt(i)-'A']++;
        }
        Arrays.sort(n);
        Arrays.sort(o);
        for (int i = 0; i < 26; i++)
            if (n[i] != o[i]) {
                System.out.print("NO");
                return ;
            }
        System.out.print("YES");
    }
}
