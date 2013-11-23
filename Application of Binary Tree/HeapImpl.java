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
public class HeapImpl {
    
    public static void addNum(int[] nums, int num, int len) {
        int i = len;
        for (; i > 0 && num < nums[(i-1)/2]; i = (i-1)/2)
            nums[i] = nums[(i-1)/2];
        nums[i] = num;
    }
    
    public static int deleteMin(int[] nums, int len) {
        int num = nums[0];
        int i = 0;
        int j = 2 * i + 1;
        while (j < len) {
            if (j+1 < len && nums[j] > nums[j+1])
                j++;
            if (nums[len] <= nums[j]) break;
            nums[i] = nums[j];
            i = j;
            j = 2 * i + 1;
        }
        nums[i] = nums[len];
        return num;
    }
    
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        while (cnt-- > 0) {
            int len = 0;
            int count = scan.nextInt();
            int[] nums = new int[count];
            while (count-- > 0) {
                int type = scan.nextInt();
                if (type == 1) {
                    int num = scan.nextInt();
                    addNum(nums, num, len++);
                } else if (type == 2) {
                    int temp = deleteMin(nums, --len);
                    System.out.println(temp);
                }
            }
        }
    }
}
