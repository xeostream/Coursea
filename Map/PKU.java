/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class PKU {
    static class Vertex {
        String name;
        int weight = Integer.MAX_VALUE;
        Vertex parent = null;
        boolean visited = false;
        HashMap<String, Integer> edges = new HashMap<String, Integer>();
        Vertex(String s) { 
            name = s;
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        HashMap<String, Vertex> vertexs = new HashMap<String, Vertex>();
        while (cnt-- > 0) {
            String str = scan.nextLine();
            vertexs.put(str, new Vertex(str));
        }
        cnt = Integer.parseInt(scan.nextLine());
        while (cnt-- > 0) {
            String[] strs = scan.nextLine().split(" ");
            Vertex v1 = vertexs.get(strs[0]);
            Vertex v2 = vertexs.get(strs[1]);
            int weight = Integer.parseInt(strs[2]);
            v1.edges.put(strs[1], weight);
            v2.edges.put(strs[0], weight);
        }
        cnt = Integer.parseInt(scan.nextLine());
        while (cnt-- > 0) {
            String[] strs = scan.nextLine().split(" ");
            Vertex start = vertexs.get(strs[0]), end = vertexs.get(strs[1]);
            start.weight = 0;
            ArrayList<Vertex> minV = new ArrayList<Vertex>();
            minV.add(start);
            start.visited = true;
            while (!minV.isEmpty()) {
                Vertex min = getMinV(minV);
                for (Entry<String, Integer> entry : min.edges.entrySet()) {
                    Vertex temp = vertexs.get(entry.getKey());
                    if (temp.weight > min.weight + entry.getValue()) {
                        temp.weight = min.weight + entry.getValue();
                        temp.parent = min;
                    }
                    if (!(temp.visited || minV.contains(temp))) {
                        temp.visited = true;
                        minV.add(temp);
                    }
                }
            }
            if (end.weight == Integer.MAX_VALUE) {
                System.out.println();
                continue;
            }
            Vertex temp = end;
            System.out.print(start.name);
            print(temp);
            System.out.println();
            initVertexs(vertexs);
        }
    }
    public static void initVertexs(HashMap<String, Vertex> map) {
        for (Entry<String, Vertex> entry : map.entrySet()) {
            entry.getValue().parent = null;
            entry.getValue().visited = false;
            entry.getValue().weight = Integer.MAX_VALUE;
        }
    }
    public static void print(Vertex v) {
        if (v.parent == null) return ;
        print(v.parent);
        System.out.print("->(" + (v.weight-v.parent.weight) + ")->" + v.name);
    }
    public static Vertex getMinV(ArrayList<Vertex> minV) {
        int index = 0;
        Vertex temp = minV.get(0);
        for (int i = 1; i < minV.size(); i++) {
            if (temp.weight > minV.get(i).weight) {
                index = i;
                temp = minV.get(i);
            }
        }
        minV.remove(index);
        return temp;
    }
}
