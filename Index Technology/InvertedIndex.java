/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IndexTechnology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class InvertedIndex {
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        HashMap<String, HashSet<Integer>> map = new HashMap<String, HashSet<Integer>>();
        String str;
        for (int i = 1; i <= cnt; i++) {
            int len = scan.nextInt();
            for (int j = 0; j < len; j++) {
                str = scan.next();
                if (map.containsKey(str))
                    map.get(str).add(i);
                else {
                    HashSet<Integer> temp = new HashSet<Integer>();
                    temp.add(i);
                    map.put(str, temp);
                }
            }
        }
        cnt = scan.nextInt();
        while (cnt-- > 0) {
            str = scan.next();
            if (!map.containsKey(str))
                System.out.println("NOT FOUND");
            else {
                ArrayList<Integer> result = new ArrayList<Integer>(map.get(str));
                Collections.sort(result);
                int m = 0;
                for (; m < result.size()-1; m++)
                    System.out.print(result.get(m) + " ");
                System.out.println(result.get(m));
            }
        }
        scan.close();
    }
}
