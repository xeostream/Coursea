/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InnerSortII;

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class Inversion {
    private static int[] nums;
    private static int[] L, R;
    private static int count;
    private static void merge(int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        for (int i = 1; i <= n1; i++)
            L[i] = nums[left+i-1];
        for (int i = 1; i <= n2; i++)
            R[i] = nums[mid+i];
        L[n1+1] = R[n2+1] = Integer.MAX_VALUE;
        int m = 1, n = 1;
        for (int i = left; i <= right; i++) {
            if (L[m] <= R[n])
                nums[i] = L[m++];
            else {
                nums[i] = R[n++];
                count += (n1 - m + 1);
            }
        }
    }
    private static void mergeSort(int left, int right) {
        if (left >= right) return ;
        int mid = (left + right) >> 1;
        mergeSort(left, mid);
        mergeSort(mid+1, right);
        merge(left, mid, right);
    }
    public static void main(String ...args) {
        Scanner scan = new Scanner(System.in);
        int i;
        while ((i=scan.nextInt()) != 0) {
            nums = new int[i+1];
            L = new int[i+1];
            R = new int[i+1];
            count = 0;
            for (int j = 1; j <= i; j++)
                nums[j] = scan.nextInt();
            mergeSort(1, i);
            System.out.println(count);
        }
    }
}
