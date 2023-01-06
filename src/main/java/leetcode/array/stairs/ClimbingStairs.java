package leetcode.array.stairs;

public class ClimbingStairs {

    public int climbStairs(int n) {
        return fib(n + 1);
    }

    private int fib(int n) {
        int[] fa = new int[n + 2];

        fa[0] = 0;
        fa[1] = 1;

        for (int i = 2; i <= n; i++) {
            fa[i] = fa[i - 1] + fa[i - 2];
        }

        return fa[n];
    }
}
