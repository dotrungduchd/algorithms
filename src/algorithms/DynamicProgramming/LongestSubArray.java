/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.DynamicProgramming;

/**
 *
 * @author ducdt
 */
public class LongestSubArray {

    public static void main(String[] args) {

        int[] A = {1, 2, 5, 4, 3, 7, 8, 9, 6};
        int N = A.length;
        int[] L = new int[N];

        for (int i = 0; i < N; i++) {

            L[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] <= A[i] && (L[i] < L[j] + 1)) {
                    L[i] = L[j] + 1;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(L[i]);
        }
    }
}
