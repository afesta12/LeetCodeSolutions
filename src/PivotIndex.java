import java.util.Arrays;

public class PivotIndex {

    /**
     * Given an array of integers nums, calculate the pivot index of this array.
     *
     * The pivot index is the index where the sum of all the numbers strictly to the left of the index
     * is equal to the sum of all the numbers strictly to the index's right.
     *
     * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
     * This also applies to the right edge of the array.
     *
     * Return the leftmost pivot index. If no such index exists, return -1.
     * @param nums the array
     * @return the index that satisfies the condition or -1
     */
    public int pivotIndex(int[] nums) {

        int leftSum = 0, len = nums.length, runningSum = 0;

        for(int n : nums) runningSum += n;

        for(int i = 0; i < len; i++) {

            if(leftSum == runningSum - leftSum - nums[i]) return i;
            leftSum += nums[i];

        }

        return -1;
    }

    /*
    Initial thought process - I did not think to use a variable for the total sum of the array, instead I used a prefix
    sum array.
     */
    public static int pivotIndexInitial(int[] nums) {

        int[] prefix = nums.clone();
        int leftSum = 0;

        // Prefix sum array
        for(int i = 1; i < prefix.length; i++) prefix[i] += prefix[i - 1];

        for(int i = 0; i < prefix.length; i++) {

            if(leftSum == prefix[prefix.length - 1] - leftSum - nums[i]) return i;
            leftSum += nums[i];

        }

        return -1;
    }
}
