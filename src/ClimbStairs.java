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

    /*
    Time limit exceeded using recursion for n = 44.
     */
    public int climbStairsTLE(int n) {

        if(n == 0 || n == 1) return 1;

        return climbStairs(n - 2) + climbStairs(n - 1);
    }

}
