/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTreeBasic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class TextBinaryTree {
    private static int index = 0;
    
    static class Node {
        String val;
        Node left, right;
        Node(String x) {
            val = x;
        }
    }
    
    public static void initTree(Node node, ArrayList<String> record, String s, boolean lorr) {
        index++;
        if (index >= record.size()) return ;
        if (record.get(index).startsWith(s)) {
            if (!record.get(index).endsWith("*")) {
                int len = record.get(index).length();
                if (lorr) {
                    node.left = new Node(record.get(index).substring(len-1));
                    initTree(node.left, record, s+"-", true);
                    initTree(node.left, record, s+"-", false);
                } else {
                    node.right = new Node(record.get(index).substring(len-1));
                    initTree(node.right, record, s+"-", true);
                    initTree(node.right, record, s+"-", false);
                }
            }
        } else
            index--;
    }
    
    public static void beforeOrder(Node root) {
        if (root == null) return ;
        System.out.print(root.val);
        beforeOrder(root.left);
        beforeOrder(root.right);
    }
    
    public static void inOrder(Node root) {
        if (root == null) return ;
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }
    
    public static void postOrder(Node root) {
        if (root == null) return ;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }
    
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        while (cnt-- > 0) {
            index = 0;
            ArrayList<String> record = new ArrayList<String>();
            String line = scan.nextLine();
            while (!line.equals("0")) {
                if (!line.equals(""))
                    record.add(line);
                line = scan.nextLine();
            }
            Node root = new Node(record.get(index));
            initTree(root, record, "-", true);
            initTree(root, record, "-", false);
            beforeOrder(root);
            System.out.println();
            postOrder(root);
            System.out.println();
            inOrder(root);
            System.out.println();
            System.out.println();
        }
    }
}
