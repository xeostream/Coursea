/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Index;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class FindandCatch {
    public static int Find(int x, int[] father, int[] rank) {
        if (father[x] == x) return x;
        int t = father[x];
        father[x] = Find(father[x], father, rank);
        rank[x] = (rank[x] + rank[t]) % 2;
        return father[x];
    }
    public static void Union(int x, int y, int[] father, int[] rank) {
        int fx = Find(x, father, rank), fy = Find(y, father, rank);
        father[fx] = fy;
        rank[fx] = (rank[x] + rank[y] + 1) % 2;
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        while (cnt-- > 0) {
            String[] line = scan.nextLine().split(" ");
            int N = Integer.parseInt(line[0]), M = Integer.parseInt(line[1]);
            int[] father = new int[N+1], rank = new int[N+1];
            for (int i = 0; i <= N; i++) {
                father[i] = i;
                rank[i] = 0;
            }
            while (M-- > 0) {
                line = scan.nextLine().split(" ");
                int x = Integer.parseInt(line[1]), y = Integer.parseInt(line[2]);
                if (line[0].equals("A")) {
                    if (Find(x, father, rank) != Find(y, father, rank))
                        System.out.println("Not sure yet.");
                    else {
                        if (rank[x] == rank[y])
                            System.out.println("In the same gang.");
                        else
                            System.out.println("In different gangs.");
                    }
                } else
                    Union(x, y, father, rank);
            }
        }
    }
}
