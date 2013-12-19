/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InnerSortII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class DNASort {
    static class Node {
        int left, right;
        int count;
        Node(int l, int r) {
            left = l;
            right = r;
            count = 0;
        }
    }
    static class Data {
        String val;
        int count;
        int index;
        Data(String v, int i) {
            val = v;
            index = i;
            count = 0;
        }
    }
    static class MyComparator implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            if (o1.count != o2.count)
                return o1.count - o2.count;
            else
                return o2.index - o1.index;
        }
    }
    public static void insert(Node[] nodes, int i, int x) {
        if (i >= nodes.length) return ;
        nodes[i].count++;
        if (nodes[i].left == nodes[i].right)
            return ;
        int mid = (nodes[i].left + nodes[i].right) >> 1;
        if (x <= mid)
            insert(nodes, (i<<1)+1, x);
        else
            insert(nodes, (i<<1)+2, x);
    }
    public static int query(Node[] nodes, int i, int l, int r) {
        if (l > r || i >= nodes.length) return 0; 
        Node temp = nodes[i];
        if (temp == null || temp.count == 0) return 0;
        if (temp.left == l && temp.right == r)
            return temp.count;
        int mid = (temp.left + temp.right) >> 1;
        if (r <= mid)
            return query(nodes, (i<<1)+1, l, r);
        else if (l > mid)
            return query(nodes, (i<<1)+2, l, r);
        else
            return query(nodes, (i<<1)+1, l, mid) + query(nodes, (i<<1)+2, mid+1, r);
    }
    public static void main(String ...args) {
        char[] dict = {'A', 'C', 'G', 'T'};
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < 4; i++)
            map.put(dict[i], i);
        Node[] nodes = new Node[7];
        nodes[0] = new Node(0, 3);
        nodes[1] = new Node(0, 1);
        nodes[2] = new Node(2, 3);
        nodes[3] = new Node(0, 0);
        nodes[4] = new Node(1, 1);
        nodes[5] = new Node(2, 2);
        nodes[6] = new Node(3, 3);
        Scanner scan = new Scanner(System.in);
        String[] strs = scan.nextLine().split(" ");
        int i = Integer.parseInt(strs[0]), j = Integer.parseInt(strs[1]);
        Data[] datas = new Data[j];
        for (int m = 0; m < j; m++)
            datas[m] = new Data(scan.nextLine(), m);
        for (int m = 0; m < j; m++) {
            String str = datas[m].val;
            for (Node n : nodes)
                n.count = 0;
            int inversion = 0;
            for (char c : str.toCharArray()) {
                if (c != 'T')
                    inversion += query(nodes, 0, map.get(c)+1, 3);
                insert(nodes, 0, map.get(c));
            }
            datas[m].count = inversion;
        }
        Arrays.sort(datas, new MyComparator());
        for (Data d : datas)
            System.out.println(d.val);
    }
}
