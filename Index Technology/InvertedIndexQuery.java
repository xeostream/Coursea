/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IndexTechnology;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class InvertedIndexQuery {
    public static void init(int[] result, int[] temp, int type) {
        if (type == 0) return ;
        Arrays.sort(result);
        Arrays.sort(temp);
        if (type == 1) {
            for (int i = 0; i < result.length; i++) {
                if (result[i] == -1) continue;
                if (Arrays.binarySearch(temp, result[i]) < 0)
                    result[i] = -1;
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                if (result[i] == -1) continue;
                if (Arrays.binarySearch(temp, result[i]) >= 0)
                    result[i] = -1;
            }
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[][] index = new int[len][];
        for (int i = 0; i < len; i++) {
            int l = scan.nextInt();
            index[i] = new int[l];
            for (int j = 0; j < l; j++)
                index[i][j] = scan.nextInt();
        }
        int queryCnt = scan.nextInt();
        int[] query = new int[len];
        while (queryCnt-- > 0) {
            System.out.println(query.length + " ");
            int temp = 0;
            int i = 0;
            for (; i < len; i++) {
                query[i] = scan.nextInt();
                if (query[i] == 1) temp = i;
            }
            System.out.println(query.length);
            for (int q : query)
                System.out.print(q + " ");
            System.out.println(query.length);
            int[] result = index[temp];
            query[temp] = 0;
            for (int j = 0; j < len; j++) {
                init(result, index[j], query[j]);
            }
            Arrays.sort(result);
            len = result.length;
            if (result[len-1] < 0)
                System.out.println("NOT FOUND");
            else {
                for (int j = 0; j < len-1; j++) {
                    if (result[i] >= 0)
                        System.out.print(result[j] + " ");
                }
                System.out.println(result[len-1]);
            }
        }
    }
}
