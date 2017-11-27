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
public class Checkerboard {

    public static int[][] c = new int[][]{
        {6, 7, 4, 6, 8},
        {7, 6, 1, 1, 4},
        {3, 5, 7, 8, 2},
        {2, 6, 7, 0, 2},
        {7, 3, 5, 6, 1}
    };

    public static int n = 5;
    public static int[][] q = new int[][]{
        {6, 7, 4, 6, 8},
        {9999, 9999, 9999, 9999, 9999},
        {9999, 9999, 9999, 9999, 9999},
        {9999, 9999, 9999, 9999, 9999},
        {9999, 9999, 9999, 9999, 9999}
    };

    public static int[][] p = new int[5][5];

    public static void main(String[] args) {
        computeShortestPath();
    }

    public static int min(int x, int y, int z) {
        if (x < y) {
            return (x < z) ? x : z;
        } else {
            return (y < z) ? y : z;
        }
    }

    public static void computeShortestPathArrays() {

        for (int y = 1; y < n; y++) {
            for (int x = 0; x < n; x++) {

                int left = 0, center = 0, right = 0;

                if (x - 1 < 0) {
                    left = 9999;
                } else {
                    left = q[y - 1][x - 1];
                }

                if (x + 1 > n - 1) {
                    right = 9999;
                } else {
                    right = q[y - 1][x + 1];
                }

                if (y - 1 == 0 && x >= 0 && x < n) {
                    center = c[y - 1][x];
                    if (x > 0) {
                        q[y - 1][x - 1] = c[y - 1][x - 1];
                    }
                    if (x < n - 1) {
                        q[y - 1][x + 1] = c[y - 1][x + 1];
                    }
                } else {
                    center = q[y - 1][x];
                }

                int m = min(left, right, center);
                q[y][x] = m + c[y][x];

                if (m == left) {
                    p[y][x] = -1;
                } else if (m == center) {
                    p[y][x] = 0;
                } else {
                    p[y][x] = 1;
                }
            }
        }

    }

    public static void computeShortestPath() {

        computeShortestPathArrays();

        for (int[] q1 : q) {
            for (int j = 0; j < q1.length; j++) {
                System.out.print(q1[j] + "\t");
            }
            System.out.println("");
        }

        int minIndex = 0;
        int min = q[n - 1][0];

        for (int i = 0; i < n; i++) {

            if (q[n - 1][i] < min) {
                minIndex = i;
                min = q[n - 1][i];
            }
        }

        printPath(n - 1, minIndex);
        System.out.println("");
    }

    public static void printPath(int y, int x) {

        System.out.print(String.format("{%s,%s}", y, x));
        System.out.print(" <<<< ");
        if (y == 0) {
            System.out.print(String.format("{%s,%s}", y, x + p[y][x]));
        } else {
            printPath(y - 1, x + p[y][x]);
        }
    }
}
