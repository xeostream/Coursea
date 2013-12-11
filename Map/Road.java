/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class Road {
    static class Edge {
        char v1, v2;
        int weight;
        Edge(char v1, char v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            weight = w;
        }
    }
    static class MyComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        int temp = cnt - 1;
        ArrayList<Edge> road = new ArrayList<Edge>();
        while (temp-- > 0) {
            String[] strs = scan.nextLine().split(" ");
            if (strs[1].equals("0")) continue;
            char v1 = strs[0].charAt(0);
            for (int i = 2; i < strs.length;) {
                char v2 = strs[i++].charAt(0);
                int weight = Integer.parseInt(strs[i++]);
                road.add(new Edge(v1, v2, weight));
            }
        }
        Collections.sort(road, new MyComparator());
        HashSet<Character> vertex = new HashSet<Character>();
        ArrayList<Edge> record = new ArrayList<Edge>();
        vertex.add(road.get(0).v1);
        vertex.add(road.get(0).v2);
        record.add(road.get(0));
        road.remove(0);
        while (vertex.size() < cnt) {
            int index = 0;
            for (; index < road.size(); index++) {
                if (!(vertex.contains(road.get(index).v1) || vertex.contains(road.get(index).v2)))
                    continue;
                break;
            }
            if (vertex.contains(road.get(index).v1) && vertex.contains(road.get(index).v2))
                road.remove(index);
            else {
                char c1 = road.get(index).v1, c2 = road.get(index).v2;
                if (vertex.contains(c2)) {
                    c1 = c2;
                    c2 = road.get(index).v1;
                }
                vertex.add(c2);
                record.add(road.get(index));
            }
        }
        int result = 0;
        for (Edge e : record)
            result += e.weight;
        System.out.println(result);
    }
}
