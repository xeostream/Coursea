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
public class HuffmanTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }
    public static void addNum(TreeNode[] nums, TreeNode num, int len) {
        int i = len;
        for (; i > 0 && num.val < nums[(i-1)/2].val; i = (i-1)/2)
            nums[i] = nums[(i-1)/2];
        nums[i] = num;
    }
    public static TreeNode deleteMin(TreeNode[] nums, int len) {
        TreeNode num = nums[0];
        int i = 0;
        int j = 2 * i + 1;
        while (j < len) {
            if (j+1 < len && nums[j].val > nums[j+1].val)
                j++;
            if (nums[len].val <= nums[j].val) break;
            nums[i] = nums[j];
            i = j;
            j = 2 * i + 1;
        }
        nums[i] = nums[len];
        return num;
    }
    public static TreeNode buildTree(TreeNode[] nums, int len) {
        TreeNode i = deleteMin(nums, --len);
        TreeNode j = deleteMin(nums, --len);
        TreeNode parent = new TreeNode(i.val+j.val, i, j);
        if (len > 0) {
            addNum(nums, parent, len++);
            return buildTree(nums, len);
        }
        return parent;
    }
    public static int sum(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        while (cnt-- > 0) {
            int len = scan.nextInt();
            TreeNode[] nums = new TreeNode[len];
            int temp = 0;
            while (len-- > 0) {
                int num = scan.nextInt();
                TreeNode node = new TreeNode(num);
                addNum(nums, node, temp++);
            }
            TreeNode root = buildTree(nums, temp);
            System.out.println(sum(root));
        }
    }
}
