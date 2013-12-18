/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InnerSort;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class Vote {
    static class Row {
        int index;
        int first, second;
        Row(int i, int f, int s) {
            index = i;
            first = f;
            second = s;
        }
    }
    public static void swap(Row[] rows, int b, int e) {
        if (b >= e) return ;
        Row temp = rows[b];
        rows[b] = rows[e];
        rows[e] = temp;
    }
    public static void quickSelect(Row[] rows, int begin, int end, int key) {
        if (begin >= end) return ;
        int pivot = (int) (Math.random() * (end-begin) + begin);
        swap(rows, begin, pivot);
        int i = begin, j = end;
        while (i < j) {
            while (i <= end && rows[i].first >= rows[begin].first)
                i++;
            while (j >= 0 && rows[j].first <= rows[begin].first)
                j--;
            if (i < j)
                swap(rows, i, j);
        }
        swap(rows, begin, i-1);
        if (key == i-begin) return ;
        else if (key < i-begin)
            quickSelect(rows, begin, i-1, key);
        else
            quickSelect(rows, i, end, key-i+begin);
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt(), j = scan.nextInt();
        Row[] rows = new Row[i];
        for (int n = 0; n < i; n++) {
            int Ai = scan.nextInt(), Bi = scan.nextInt();
            rows[n] = new Row(n+1, Ai, Bi);
        }
        quickSelect(rows, 0, i-1, j);
        Row president = rows[0];
        for (int m = 1; m < j; m++)
            if (president.second < rows[m].second)
                president = rows[m];
        System.out.println(president.index);
    }
}
