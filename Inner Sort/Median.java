/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InnerSort;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class Median {
    public static void swap(int[] nums, int b, int e) {
        if (b >= e) return ;
        int temp = nums[b];
        nums[b] = nums[e];
        nums[e] = temp;
    }
    public static void quickSort(int[] nums, int begin, int end, int key) {
        if (begin >= end) return ;
        int pivot = (int) (Math.random() * (end-begin) + begin);
        swap(nums, pivot, begin);
        int i = begin, j = end;
        while (i < j) {
            while (i <= end && nums[i] <= nums[begin])
                i++;
            while (j >= 0 && nums[j] >= nums[begin])
                j--;
            if (i < j)
                swap(nums, i, j);
        }
        swap(nums, begin, i-1);
        if (key == i-begin) return ;
        else if (key < i-begin)
            quickSort(nums, begin, i-1, key);
        else
            quickSort(nums, i, end, key-i+begin);
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++)
            nums[i] = scan.nextInt();
        int mid = len / 2 + 1;
        quickSort(nums, 0, len-1, mid);
        System.out.println(nums[mid-1]);
    }
}
