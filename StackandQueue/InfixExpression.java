/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StackandQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Arthur
 */
public class InfixExpression {
    public static void main(String ...args) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('(', 3);
        map.put(')', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        while (cnt-- > 0) {
            Stack<String> infix = new Stack<String>();
            ArrayList<String> temp = new ArrayList<String>();
            String exp = scan.nextLine();
            int result = 0;
            int begin = 0, end = 0;
            while (end < exp.length()) {
                if (exp.charAt(end) >= '0' && exp.charAt(end) <= '9')
                    end++;
                else {
                    if (end > begin) {
                        temp.add(exp.substring(begin, end));
                        begin = end + 1;
                    } else {
                        if (infix.isEmpty())
                            infix.push(exp.charAt(end)+"");
                        else {
                            if (exp.charAt(end) == ')') {
                                while (!infix.peek().equals("("))
                                    temp.add(infix.pop());
                                infix.pop();
                            } else {
                                while (!infix.isEmpty() && !infix.peek().equals("(") && map.get(exp.charAt(end)) <= map.get(infix.peek().charAt(0)))
                                    temp.add(infix.pop());
                                infix.push(exp.charAt(end)+"");
                            }
                        }
                        begin = ++end;
                    }
                }
            }
            if (begin < end)
                temp.add(exp.substring(begin));
            while (!infix.isEmpty())
                temp.add(infix.pop());
            for (String str : temp) {
                //if (str.equals("")) continue;
                if (str.charAt(0) < '0' || str.charAt(0) > '9') {
                    int i = Integer.parseInt(infix.pop());
                    int j = Integer.parseInt(infix.pop());
                    switch (str.charAt(0)) {
                        case '*':
                            infix.push(i*j+"");
                            break;
                        case '/':
                            infix.push(j/i+"");
                            break;
                        case '+':
                            infix.push(i+j+"");
                            break;
                        case '-':
                            infix.push(j-i+"");
                    }
                } else
                    infix.push(str);
            }
            System.out.println(infix.pop());
        }
    }
}
