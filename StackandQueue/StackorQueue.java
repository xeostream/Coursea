/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StackandQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Arthur
 * Question http://dsalgo.openjudge.cn/dsmoochw3/3/
 */
public class StackorQueue {
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        while (cnt-- > 0) {
            Stack<Integer> stack = new Stack<Integer>();
            boolean pivot = true;
            int len = scan.nextInt();
            while (len-- > 0) {
                int type = scan.nextInt();
                int val = scan.nextInt();
                if (!pivot) continue;
                if (type == 1)
                    stack.push(val);
                else if (type == 2) {
                    int origin = stack.pop();
                    if (origin != val) {
                        pivot = false;
                    }
                }
            }
            if (pivot)
                System.out.println("Stack");
            else
                System.out.println("Queue");
        }
    }
}
