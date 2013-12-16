/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InnerSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class DistanceSort {
    static class Vertex {
        int x, y, z;
        Vertex(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Edge {
        int startPos, endPos;
        double dist;
        Edge(int start, int end, double dist) {
            this.dist = dist;
            this.startPos = start;
            this.endPos = end;
        }
    }
    static class MyComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            if (o1.dist > o2.dist)
                return -1;
            else if (o1.dist < o2.dist)
                return 1;
            else if (o1.startPos < o2.startPos)
                return -1;
            else if (o1.startPos > o2.startPos)
                return 1;
            else if (o1.endPos < o2.endPos)
                return -1;
            else if (o1.endPos > o2.endPos)
                return 1;
            else
                return 0;
        }
    }
    public static double getDist(Vertex start, Vertex end) {
        return Math.sqrt(Math.pow(start.x-end.x, 2)+Math.pow(start.y-end.y, 2)+Math.pow(start.z-end.z, 2));
    }
    public static void print(Edge e, Vertex[] vertexs) {
        Vertex s = vertexs[e.startPos], end = vertexs[e.endPos];
        System.out.println("("+s.x+","+s.y+","+s.z+")-("+end.x+","+end.y+","+end.z+")="+String.format("%1$.2f",e.dist));
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        Vertex[] vertexs = new Vertex[cnt];
        for (int i = 0; i < cnt; i++) {
            int x = Integer.parseInt(scan.next()), y = Integer.parseInt(scan.next()), z = Integer.parseInt(scan.next());
            vertexs[i] = new Vertex(x, y, z);
        }
        Edge[] edges = new Edge[cnt * (cnt - 1) / 2];
        int pos = 0;
        for (int i = 0; i < cnt; i++)
            for (int j = i + 1; j < cnt; j++)
                edges[pos++] = new Edge(i, j, getDist(vertexs[i], vertexs[j]));
        Arrays.sort(edges, new MyComparator());
        for (Edge e : edges)
            print(e, vertexs);
    }
}
