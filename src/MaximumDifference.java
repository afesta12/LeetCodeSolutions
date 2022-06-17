public class MaximumDifference {

    /**
     * Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j]
     * (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
     *
     * Return the maximum difference. If no such i and j exists, return -1.
     *
     * Idea is to keep track of the smallest value seen so far, then check the difference between that smallest value
     * and each number after it. If a new smaller value is found, change current smallest value to that number, etc.
     *
     * @param nums the array of numbers
     * @return the max difference satisfying above conditions
     */
    public static int maximumDifference(int[] nums) {

        int minSoFar = Integer.MAX_VALUE;
        int currentDiff, maxDifference = -1;

        for(int n : nums) {

            if(n < minSoFar) minSoFar = n;

            if(minSoFar < n) {

                currentDiff = n - minSoFar;
                maxDifference = Math.max(currentDiff, maxDifference);

            }

        }

        return maxDifference;
    }

}
