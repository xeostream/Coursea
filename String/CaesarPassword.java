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
public class CaesarPassword {
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String start = scan.nextLine();
            if (start.equals("ENDOFINPUT")) return ;
            String str = scan.nextLine();
            String end = scan.nextLine();
            String result = "";
            for (char c : str.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    char ch = (char) ((c-5 < 65) ? (c + 21) : (c - 5));
                    result += ch;
                } else
                    result += c;
            }
            System.out.println(result);
        }
    }
}
