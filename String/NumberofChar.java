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
public class NumberofChar {
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        while (cnt-- > 0) {
            String str = scan.nextLine();
            int[] nums = new int[26];
            for (char c : str.toCharArray())
                nums[c-'a']++;
            char c = 'a';
            int max = nums[0];
            for (int i = 1; i < 26; i++)
                if (max < nums[i]) {
                    c = (char) (i + 'a');
                    max = nums[i];
                }
            System.out.println(c + " " + max);
            if (cnt != 0) 
                str = scan.nextLine();
        }
    }
}
