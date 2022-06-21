import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {


    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top.
     *
     * @param n the number of steps to the top
     * @return the distinct ways to climb to the top of the staircase
     */
    public int climbStairs(int n) {

        int[] stairs = {1, 1};

        /*
        Use an array of size 2 to create the fibonacci sequence up to the nth step
         */
        for(int i = 0; i < n; i++) {

            int temp = stairs[0];
            stairs[0] = stairs[1];
            stairs[1] = temp + stairs[1];

        }

        return stairs[0];
    }

    // DP solution using maps, 1ms. I think it could be improved by using an array.
    public int fibDP(int n) {

        Map<Integer, Integer> memo = new HashMap<>();

        return helper(n, memo);
    }

    public int helper(int n, Map<Integer, Integer> map) {

        if(map.containsKey(n)) return map.get(n);
        if(n < 2) return 1;

        int nthStair = helper(n - 1, map) + helper(n - 2, map);
        map.put(n, nthStair);

        return nthStair;
    }

    // 0ms using DP memoization
    public int fibDPArray(int n) {

        return getStairs(n, new int[n + 1]);
    }

    public static int getStairs(int n, int[] memo) {

        if(memo[n] > 0) return memo[n];

        if(n < 2) return 1;

        int nthStair = getStairs(n - 1, memo) + getStairs(n - 2, memo);

        memo[n] = nthStair;

        return nthStair;
    }

    /*
    Time limit exceeded using recursion for n = 44.
     */
    public int climbStairsTLE(int n) {

        if(n == 0 || n == 1) return 1;

        return climbStairs(n - 2) + climbStairs(n - 1);
    }

}
