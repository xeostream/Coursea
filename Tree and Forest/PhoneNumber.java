/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TreeandForest;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class PhoneNumber {
    static class TreeNode {
        boolean hasSon;
        TreeNode[] sons = new TreeNode[10];
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        while (cnt-- > 0) {
            int num = Integer.parseInt(scan.nextLine());
            TreeNode root = new TreeNode();
            boolean result = true;
            while (num-- > 0) {
                TreeNode temp = root;
                String str = scan.nextLine();
                if (!result) continue;
                for (int i = 0; i < str.length(); i++) {
                    int index = str.charAt(i) - '0';
                    if (temp.sons[index] == null) {
                        temp.sons[index] = new TreeNode();
                        temp.hasSon = true;
                    } else {
                        if (!temp.sons[index].hasSon || i == str.length() -1) {
                            result = false;
                            break;
                        }
                    }
                    temp = temp.sons[index];
                }
            }
            if (result)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
