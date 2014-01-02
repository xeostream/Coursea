/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Index;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class SpellCheck {
    private static void find(ArrayList<String> hist, String str) {
        int state = 0, len = str.length();
        ArrayList<String> record = new ArrayList<String>();
        for (String s : hist) {
            if (s.equals(str)) {
                state = 1;
                break;
            } else if (s.length() == len) {
                int delta = 0;
                for (int i = 0; i < len; i++) {
                    if (delta > 1) break;
                    if (s.charAt(i) != str.charAt(i))
                        delta++;
                }
                if (delta == 1)
                    record.add(s);
            } else if (s.length() == len + 1) {
                int i = 0;
                while (i < len && s.charAt(i) == str.charAt(i))
                    i++;
                if (i == len)
                    record.add(s);
                else if (s.substring(i+1).equals(str.substring(i)))
                    record.add(s);
            } else if (s.length() == len - 1) {
                int i = 0;
                while (i < len - 1 && s.charAt(i) == str.charAt(i))
                    i++;
                if (i == len - 1)
                    record.add(s);
                else if (s.substring(i).equals(str.substring(i+1)))
                    record.add(s);
            }
        }
        if (state == 1)
            System.out.println(str + " is correct");
        else {
            System.out.print(str + ":");
            for (String st : record)
                System.out.print(" " + st);
            System.out.println();
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> hist = new ArrayList<String>();
        hist.ensureCapacity(10000);
        String str;
        while(!(str = scan.nextLine()).equals("#"))
            hist.add(str);
        while (!(str = scan.nextLine()).equals("#"))
            find(hist, str);
    }
}
