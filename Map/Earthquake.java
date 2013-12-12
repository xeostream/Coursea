/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class Earthquake {
    static class Vertex {
        int x, y;
        Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Edge {
        Vertex start, end;
        double weight;
        Edge(Vertex v1, Vertex v2, double w) {
            start = v1;
            end = v2;
            weight = w;
        }
    }
    static class MyComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            if (o1.weight == o2.weight)
                return 0;
            else if (o1.weight > o2.weight)
                return 1;
            else
                return -1;
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] strs = str.split(" ");
            int vCount = Integer.parseInt(strs[0]), eCount = Integer.parseInt(strs[1]);
            Vertex[] vertexs = new Vertex[vCount];
            for (int i = 0; i < vCount; i++) {
                String[] s = scan.nextLine().split(" ");
                int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
                vertexs[i] = new Vertex(m, n);
            }
            Edge[] edges = new Edge[eCount];
            for (int j = 0; j < eCount; j++) {
                String[] s = scan.nextLine().split(" ");
                int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
                Vertex v1 = vertexs[m-1], v2 = vertexs[n-1];
                double weight = Math.sqrt(Math.pow(v1.x-v2.x, 2)+Math.pow(v1.y-v2.y, 2));
                edges[j] = new Edge(v1, v2, weight);
            }
            Arrays.sort(edges, new MyComparator());
            ArrayList<Edge> eRecord = new ArrayList<Edge>();
            ArrayList<Vertex> vRecord = new ArrayList<Vertex>();
            eRecord.add(edges[0]);
            vRecord.add(edges[0].start);
            vRecord.add(edges[0].end);
            edges[0] = null;
            while (vRecord.size() < vCount) {
                boolean ct = false;
                for (Edge e : edges) {
                    if (e == null) continue;
                    if (vRecord.contains(e.start) && !vRecord.contains(e.end)) {
                        vRecord.add(e.end);
                        eRecord.add(e);
                        e = null;
                        ct = true;
                        break;
                    }
                }
                if (!ct) break;
            }
            if (vRecord.size() < vCount)
                System.out.println("NO");
            else {
                double result = 0.0;
                for (Edge eg : eRecord)
                    result += eg.weight;
                System.out.println(String.format("%1$.2f",result));
            }
        }
        scan.close();
    }
}
