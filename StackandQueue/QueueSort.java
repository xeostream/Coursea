package StackandQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * User: Arthur
 * Date: 13-11-7
 * Question: Question http://dsalgo.openjudge.cn/dsmoochw3/1/
 * To change this template use File | Settings | File Templates.
 */
public class QueueSort {
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        Queue<String>[] queues = new Queue[13];
        for (int i = 0; i < 13; i++)
            queues[i] = new LinkedList<String>();
        for (int i = 0; i < len; i++) {
            String str = scan.next();
            queues[str.charAt(1)-'1'].offer(str);
        }
        for (int i = 0; i < 9; i++) {
            System.out.print("Queue"+(i+1)+":");
            if (!queues[i].isEmpty()) {
                String temp = null;
                while (queues[i].size() > 1) {
                    temp = queues[i].poll();
                    queues[temp.charAt(0)-'A'+9].offer(temp);
                    System.out.print(temp + " ");
                }
                temp = queues[i].poll();
                queues[temp.charAt(0)-'A'+9].offer(temp);
                System.out.println(temp);
            } else
                System.out.println();
        }
        String result = "";
        for (int i = 9; i < 13; i++) {
            System.out.print("Queue"+(char) ('A' + i - 9)+":");
            if (!queues[i].isEmpty()) {
                String temp = "";
                while (queues[i].size() > 1) {
                    temp = queues[i].poll();
                    result += (temp+" ");
                    System.out.print(temp+ " ");
                }
                temp = queues[i].poll();
                result += (temp+" ");
                System.out.println(temp);
            } else
                System.out.println();
        }
        System.out.println(result);
    }
}