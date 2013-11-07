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
 * Question http://dsalgo.openjudge.cn/dsmoochw3/2/
 */
public class StackAction {
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        while (cnt-- > 0) {
            int len = scan.nextInt();
            Stack<Integer> stack = new Stack<Integer>();
            boolean key = true;
            while (len-- > 0) {
                String action = scan.next();
                if (action.equals("push")) {
                    int num = scan.nextInt();
                    stack.push(num);
                } else if (action.equals("pop")) {
                    if (stack.isEmpty())
                        key = false;
                    else
                        stack.pop();
                }
            }
            if (!key) {
                System.out.println("error");
                continue;
            }
            if (!stack.isEmpty()) {
                Stack<Integer> result = new Stack<Integer>();
                while (!stack.isEmpty())
                    result.push(stack.pop());
                while (result.size() > 1) {
                    System.out.print(result.pop() + " ");
                }
                System.out.println(result.pop());
            }
        }
    }
}
