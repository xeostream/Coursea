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
public class Religion {
    public static int Find(int[] father, int x) {
        if (father[x] == x) return x;
        father[x] = Find(father, father[x]);
        return father[x];
    }
    public static void Union(int[] father, int x, int y) {
        father[x] = y;
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = 1;
        int n = scan.nextInt(), m = scan.nextInt();
        while (n != 0 && m != 0) {
            int[] father = new int[n+1];
            for (int i = 1; i <= n; i++)
                father[i] = i;
            int i, j, num = n;
            while (m-- > 0) {
                i = scan.nextInt(); j = scan.nextInt();
                i = Find(father, i);
                j = Find(father, j);
                if (i == j) continue;
                Union(father, i, j);
                num--;
            }
            System.out.println("Case " + (cnt++) + ": " + num);
            n = scan.nextInt(); m = scan.nextInt();
        }
    }
}
