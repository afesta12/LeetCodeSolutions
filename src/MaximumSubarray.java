public class MaximumSubarray {

    /**
     * Because there are negative values in the array, a sliding window approach won't work.
     * This approach uses Kadane's Algorithm to carry the running sum as long as the running sum
     * is greater than or equal to zero, otherwise set the running sum to 0.
     * @param nums the array
     * @return the max sum
     */
    public int maxSubArray(int[] nums) {

        int runningSum = 0, max = Integer.MIN_VALUE;

        int len = nums.length;

        for(int i = 0; i < len; i++) {

            runningSum += nums[i];

            max = Math.max(runningSum, max);

            if(runningSum < 0) runningSum = 0;
        }

        return max;
    }

    /*
    Time limit exceeded with brute force approach
     */
    public int maxSubArrayTLE(int[] nums) {

        int max = Integer.MIN_VALUE;

        int len = nums.length;

        for(int i = 0; i < len; i++) {

            int runningSum = 0;

            for(int j = i; j < len; j++) {

                runningSum += nums[j];
                max = Math.max(runningSum, max);

            }

        }

        return max;
    }

}
