/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTreeBasic;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class ActionofBinaryTreeOther {
    static class Node {
        int val;
        int left;
        int right;
        int parent;
        boolean lorr;
        Node (int x, int left, int right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
        Node (int x, int left, int right, int parent) {
            this(x, left, right);
            this.parent = parent;
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        while (cnt-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt();
            Node[] tree = new Node[n];
            while (n-- > 0) {
                int cur = scan.nextInt(), left = scan.nextInt(), right = scan.nextInt();
                if (tree[cur] == null)
                    tree[cur] = new Node(cur, left, right);
            }
            for (Node node : tree) {
                if (node.left > -1) {
                    tree[node.left].parent = node.val;
                    tree[node.left].lorr = true;
                }
                if (node.right > -1) {
                    tree[node.right].parent = node.val;
                    tree[node.right].lorr = false;
                }
            }
            while (m-- > 0) {
                int type = scan.nextInt();
                if (type == 1) {
                    int i = scan.nextInt(), j = scan.nextInt();
                    boolean b1 = tree[i].lorr, b2 = tree[j].lorr;
                    if (b1)
                        tree[tree[i].parent].left = j;
                    else
                        tree[tree[i].parent].right = j;
                    tree[i].lorr = b2;
                    if (b2)
                        tree[tree[j].parent].left = i;
                    else
                        tree[tree[j].parent].right = i;
                    tree[j].lorr = b1;
                    int parent = tree[i].parent;
                    tree[i].parent = tree[j].parent;
                    tree[j].parent = parent;
                } else {
                    int i = scan.nextInt();
                    while (i != -1) {
                        if (tree[i].left != -1)
                            i = tree[i].left;
                        else {
                            System.out.println(tree[i].val);
                            break;
                        }
                    }
                }
            }
        }
    }
}
