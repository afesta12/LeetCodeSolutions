import java.util.Arrays;

public class MinStepByStepValue {

    // Keep a running sum, and if the sum is ever lower than 0, recalculate the min
    public static int minStartValue(int[] nums) {

        int min = nums[0] < 0 ? nums[0] : 1, runningSum = nums[0];

        for(int i = 1; i < nums.length; i++) {

            runningSum += nums[i];

            if(runningSum < 0) {

                min = Math.min(runningSum, min);

            }

        }

        return min < 0 ? Math.abs(min) + 1 : min;
    }

    // Initial thought was to use a prefix sum array, 1ms faster than 28%
    public int minStartValueInitial(int[] nums) {

        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];

        int min = prefix[0] < 0 ? prefix[0] : 1;

        for(int i = 1; i < nums.length; i++) {

            prefix[i] = prefix[i - 1] + nums[i];

            if(prefix[i] < 0) {
                min = Math.min(min, prefix[i]);
            }

        }

        return min < 0 ? Math.abs(min) + 1 : min;
    }

}
