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
public class InitBinaryTree {
    private static String[] inOrder;
    private static String[] postOrder;
    
    static class Node {
        String val;
        Node left, right;
        Node (String x) {
            val = x;
        }
    }
    
    public static void initTree(Node node, int ibegin, int iend, int pbegin, boolean lorr) {
        if (lorr) {
            if (ibegin == iend)
                node.left = new Node(inOrder[ibegin]);
            else if (ibegin < iend) {
                int index = -1;
                for (int i = pbegin-1; i >= 0; i--) {
                    for (int j = ibegin; j <= iend; j++) {
                        if (postOrder[i].equals(inOrder[j])) {
                            index = j;
                            break;
                        }
                    }
                    if (index != -1) break;
                }
                node.left = new Node(inOrder[index]);
                initTree(node.left, ibegin, index-1, pbegin, true);
                initTree(node.left, index+1, iend, pbegin, false);
            }
        } else {
            if (ibegin == iend)
                node.right = new Node(inOrder[ibegin]);
            else if (ibegin < iend) {
                int index = -1;
                for (int i = pbegin-1; i >= 0; i--) {
                    for (int j = ibegin; j <= iend; j++) {
                        if (postOrder[i].equals(inOrder[j])) {
                            index = j;
                            break;
                        }
                    }
                    if (index != -1) break;
                }
                node.right = new Node(inOrder[index]);
                initTree(node.right, ibegin, index-1, pbegin, true);
                initTree(node.right, index+1, iend, pbegin, false);
            }
        }
    }
    
    public static void beforeOrder(Node root, String s) {
        if (root == null) return ;
        System.out.print(s + root.val);
        beforeOrder(root.left, " ");
        beforeOrder(root.right, " ");
    }
    
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        inOrder = scan.nextLine().split(" ");
        postOrder = scan.nextLine().split(" ");
        int len = postOrder.length;
        Node root = new Node(postOrder[len-1]);
        int index = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (postOrder[len-1].equals(inOrder[i])) {
                index = i;
                break;
            }
        }
        initTree(root, 0, index-1, len-1, true);
        initTree(root, index+1, len-1, len-1, false);
        beforeOrder(root, "");
    }
}
