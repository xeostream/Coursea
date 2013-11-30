/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TreeandForest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Arthur
 */
public class MatterResolveRecord {
    static class TreeNode {
        String val;
        ArrayList<TreeNode> nodes;
        TreeNode(String s) { val = s; }
    }
    private static boolean visit(TreeNode node, String str) {
        if (node.nodes == null) return false;
        for (int i = 0; i < node.nodes.size();i++) {
            if (str.equals(node.nodes.get(i).val)) {
                if (i == node.nodes.size()-1) return true;
                for (int j = i+1; j < node.nodes.size(); j++)
                    System.out.print(node.nodes.get(j).val);
                System.out.println();
                return true;
            } else if (visit(node.nodes.get(i), str))
                return true;
        }
        return false;
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        while (cnt-- > 0) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            String str = scan.nextLine();
            while (!str.equals("")) {
                if (str.equals("}")) {
                    ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
                    while (!stack.peek().val.equals("{"))
                        nodes.add(stack.pop());
                    stack.pop();
                    TreeNode node = stack.peek();
                    Collections.reverse(nodes);
                    node.nodes = nodes;
                } else
                    stack.push(new TreeNode(str));
                str = scan.nextLine();
            }
            ArrayList<TreeNode> son = new ArrayList<TreeNode>();
            while (!stack.isEmpty())
                son.add(stack.pop());
            Collections.reverse(son);
            str = scan.nextLine();
            boolean key = false;
            for (TreeNode tn : son)
               if(visit(tn, str)) {
                   key = true;
                   break;
               }
            if (!key)
                System.out.println("No");
            scan.nextLine();
            scan.nextLine();
        }
        if (scan.nextLine().equals("!")) return ;
    }
}
