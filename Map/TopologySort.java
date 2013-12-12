/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Map;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class TopologySort {
    static class Vertex {
        int val;
        ArrayList<Vertex> parents;
        Vertex(int x) {
            val = x;
            parents = new ArrayList<Vertex>();
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int vCount = scan.nextInt();
        int eCount = scan.nextInt();
        Vertex[] vertexs = new Vertex[vCount];
        for (int i = 1; i <= vCount; i++)
            vertexs[i-1] = new Vertex(i);
        while (eCount-- > 0) {
            int i = scan.nextInt(), j = scan.nextInt();
            if (!vertexs[j-1].parents.contains(vertexs[i-1]))
                vertexs[j-1].parents.add(vertexs[i-1]);
        }
        while (vCount > 1) {
            for (int i = 0; i < vertexs.length; i++) {
                if (vertexs[i] == null) continue;
                if (vertexs[i].parents.isEmpty()) {
                    System.out.print("v" + vertexs[i].val + " ");
                    for (Vertex v : vertexs) {
                        if (v == null) continue;
                        v.parents.remove(vertexs[i]);
                    }
                    vertexs[i] = null;
                    vCount--;
                    break;
                }
            }
        }
        for (Vertex v : vertexs)
            if (v != null)
                System.out.print("v" + v.val);
        System.out.println();
    }
}
