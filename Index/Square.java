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
public class Square {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class HashNode {
        int x, y;
        HashNode next;
        HashNode(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int getHash(int x, int y) {
        return (x*x*31+y*y) % 3999;
    }
    private static void insert(int x, int y, HashNode[] link) {
        int hash = getHash(x, y);
        HashNode node = new HashNode(x, y);
        node.next = link[hash].next;
        link[hash].next = node;
    }
    private static boolean find(int x, int y, HashNode[] link) {
        int hash = getHash(x, y);
        HashNode node = link[hash].next;
        boolean result = false;
        while (node != null) {
            if (node.x == x && node.y == y) {
                result = true;
                break;
            }
            node = node.next;
        }
        return result;
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int num;
        while ((num = Integer.parseInt(scan.nextLine())) != 0) {
            if (num < 4) {
                while (num-- > 0)
                    scan.nextLine();
                System.out.println(0);
                continue;
            }
            Point[] points = new Point[num];
            HashNode[] link = new HashNode[4000];
            for (int i = 0; i < link.length; i++)
                link[i] = new HashNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
            String[] line;
            int x, y;
            for (int i = 0; i < num; i++) {
                line = scan.nextLine().split(" ");
                x = Integer.parseInt(line[0]);
                y = Integer.parseInt(line[1]);
                Point p = new Point(x, y);
                int j = i-1;
                for (; j >= 0; j--) {
                    if (points[j].x > x || (points[j].x == x && points[j].y > y))
                        points[j+1] = points[j];
                    else
                        break;
                }
                points[j+1] = p;
                insert(x, y, link);
            }
            int cnt = 0;
            for (int i = 0; i < num; i++) {
                for (int j = i+1; j < num; j++) {
                    x = points[i].y - points[j].y + points[i].x;
                    y = points[j].x - points[i].x + points[i].y;
                    if (!find(x, y, link)) continue;
                    x = points[i].y - points[j].y + points[j].x;
                    y = points[j].x - points[i].x + points[j].y;
                    if (find(x, y, link))
                        cnt++;
                }
            }
            System.out.println(cnt / 2);
        }
    }
}
