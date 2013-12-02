/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TreeandForest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class TreeTransform {
    static class TreeNode {
        int val;
        TreeNode parent;
        ArrayList<TreeNode> sons;
        TreeNode (int x) { val = x; }
    }
    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left, right;
        BinaryTreeNode(int x) { val = x; }
    }
    public static int GetHeight (TreeNode node) {
        if (node.sons == null) return 1;
        int height = 0, temp;
        for (TreeNode tn : node.sons) {
            temp = GetHeight(tn) + 1;
            height = Math.max(temp, height);
        }
        return height;
    }
    public static int GetHeight(BinaryTreeNode node) {
        if (node == null) return 0;
        int left = GetHeight(node.left);
        int right = GetHeight(node.right);
        return Math.max(left, right) + 1;
    }
    public static void BuildBT(TreeNode tn, BinaryTreeNode btn) {
        if (tn.sons == null) return ;
        btn.left = new BinaryTreeNode(tn.sons.get(0).val);
        BuildBT(tn.sons.get(0), btn.left);
        if (tn.sons.size() > 1) {
            BinaryTreeNode node = btn.left;
            for (int i = 1; i < tn.sons.size(); i++) {
                node.right = new BinaryTreeNode(tn.sons.get(i).val);
                BuildBT(tn.sons.get(i), node.right);
                node = node.right;
            }
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int cnt = 1;
        while (!str.equals("#")) {
            int val = 0;
            TreeNode root = new TreeNode(val++);
            TreeNode temp = root;
            for (char c : str.toCharArray()) {
                if (c == 'd') {
                    TreeNode node = new TreeNode(val++);
                    node.parent = temp;
                    if (temp.sons == null)
                        temp.sons = new ArrayList<TreeNode>();
                    temp.sons.add(node);
                    temp = node;
                } else
                 temp = temp.parent;   
            }
            int origin = GetHeight(root) - 1;
            BinaryTreeNode btn = new BinaryTreeNode(root.val);
            BuildBT(root, btn);
            int now = GetHeight(btn) - 1;
            System.out.println("Tree "+ (cnt++) + ": " + origin + " => " + now);
            str = scan.nextLine();
        }
    }
}
