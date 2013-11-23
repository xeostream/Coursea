/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ApplicationofBinaryTree;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class BST {
    static class TreeNode {
        int val;
        int count;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
            count = 1;
        }
    }
    public static void addNode(TreeNode root, int num) {
        if (root.val == num)
            root.count++;
        else if (root.val < num) {
            if (root.right != null)
                addNode(root.right, num);
            else
                root.right = new TreeNode(num);
        } else {
            if (root.left != null)
                addNode(root.left, num);
            else
                root.left = new TreeNode(num);
        }
    }
    public static void preorder(TreeNode root) {
        if (root == null) return ;
            System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        String[] nodes = scan.nextLine().split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        for (int i = 1; i < nodes.length; i++)
            addNode(root, Integer.parseInt(nodes[i]));
        preorder(root);
    }
}
