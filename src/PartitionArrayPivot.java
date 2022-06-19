import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayPivot {

    /**
     * You are given a 0-indexed integer array nums and an integer pivot.
     * Rearrange nums such that the following conditions are satisfied:
     *
     * Every element less than pivot appears before every element greater than pivot.
     * Every element equal to pivot appears in between the elements less than and greater than pivot.
     * The relative order of the elements less than pivot and the elements greater than pivot is maintained.
     * More formally, consider every pi, pj where pi is the new position of the ith element
     * and pj is the new position of the jth element. For elements less than pivot,
     * if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj.
     * Similarly for elements greater than pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.
     *
     * Return nums after the rearrangement.
     *
     * Use a two pointer approach to keep track of the index to write to in the array (left = 0, right = nums.length - 1.
     * If nums[left] < pivot, write number to result[left] and increment left, then check nums[right],
     * if it's greater than pivot, write number to result[right] and decrement right.
     * This keeps the elements in their original order.
     *
     * After that, left and right will be at the indexes where the pivot number will be placed.
     *
     * @param nums the array
     * @param pivot the number to pivot on
     * @return the array after the pivot
     */
    public static int[] pivotArray(int[] nums, int pivot) {

        int len = nums.length;
        int[] result = new int[len];

        int left = 0, right = len - 1;

        for(int i = 0; i < len; i++) {

            /*
            Check start and end of array to keep elements in their original order
             */
            if(nums[i] < pivot) {

                result[left++] = nums[i];

            }

            if(nums[len - 1 - i] > pivot) {

                result[right--] = nums[len - 1 - i];

            }

        }

        while(left <= right) {

            result[left++] = pivot;
            result[right--] = pivot;

        }

        return result;
    }

    // Initial idea was to have 3 separate arrays for smaller, equal and greater than pivot. Accepted, slow and uses
    // a lot of memory.
    public int[] pivotArrayInitial(int[] nums, int pivot) {

        int len = nums.length;
        int[] result = new int[len];

        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for(int n : nums) {

            if(n > pivot) large.add(n);
            else if(n < pivot) small.add(n);
            else equal.add(n);

        }

        int index = 0;
        for (Integer integer : small) result[index++] = integer;
        for (Integer integer : equal) result[index++] = integer;
        for (Integer integer : large) result[index++] = integer;

        return result;
    }

}
