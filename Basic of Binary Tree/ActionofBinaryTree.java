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
public class ActionofBinaryTree {
    public static void swap(int i, int j, int[] nums) {
        if (i < nums.length && j < nums.length && (nums[i] != -1 || nums[j] != -1)) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            swap(2*i+1, 2*j+1, nums);
            swap(2*i+2, 2*j+2, nums);
        }
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        while (count-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt();
            int len = (int) (Math.pow(2, n) + 1);
            int[] nums = new int[len];
            for (int i = 1; i < len; i++)
                nums[i] = -1;
            int index = 0;
            while (n-- > 0) {
                int cur = scan.nextInt(), left = scan.nextInt(), right = scan.nextInt();
                for (int i = index; i < len; i++) {
                    if (nums[i] == cur) {
                        nums[2*i+1] = left;
                        nums[2*i+2] = right;
                        break;
                    }
                }
                index++;
            }
            while (m-- > 0) {
                int type = scan.nextInt();
                if (type == 1) {
                    int i = scan.nextInt(), j = scan.nextInt();
                    int e = 0, p = 0;
                    for (int t = 0; t < len; t++) {
                        if (nums[t] == i) {
                            e = t;
                            break;
                        }
                    }
                    for (int t = 0; t < len; t++) {
                        if (nums[t] == j) {
                            p = t;
                            break;
                        }
                    }
                    swap(e, p, nums);
                } else if (type == 2) {
                    int i = scan.nextInt();
                    int in = 0;
                    for (; in < n && nums[in] != i; in++) ;
                    while (nums[in] != -1) {
                        if (nums[2*in+1] != -1)
                            in = 2*in+1;
                        else {
                            System.out.println(nums[in]);
                            break;
                        }
                    }
                }
            }
        }
    }
}
