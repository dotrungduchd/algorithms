/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ducdt
 */
public class Fibonacci {

    public static long count = 0;

    public static void main(String[] args) {

        long n = 40000;
        long result = fibAddition(n);
        System.out.println(String.format("fib(%s) = %s, count = %s", n, result, count));
    }

    public static long fib(long n) {

        count++;

        if (n == 0 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static final Map<Long, Long> map = new HashMap<>();

    static {
        map.put(0l, 1l);
        map.put(1l, 1l);
    }

    public static long fibUseMap(long n) {

        count++;

        if (map.get(n) == null) {
            map.put(n, fibUseMap(n - 1) + fibUseMap(n - 2));
        }

        return map.get(n);
    }

    public static long fibAddition(long n) {

        count++;

        long prev = 1;
        long curr = 1;

        for (int i = 2; i <= n; i++) {
            long newFib = prev + curr;
            prev = curr;
            curr = newFib;
        }

        return curr;
    }
}
