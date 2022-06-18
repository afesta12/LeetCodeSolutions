import java.util.Arrays;

public class ReplaceElementsWithGreatestOnRightSide {

    /**
     * Given an array arr, replace every element in that array with the greatest element among the
     * elements to its right, and replace the last element with -1.
     *
     * After doing so, return the array.
     *
     * @param arr the array
     * @return the array after changing the elements
     */
    public static int[] replaceElements(int[] arr) {

        /*
        Array's length and set the currentMax to be -1
         */
        int len = arr.length;
        int currentMax = -1;

        for(int i = len - 1; i >= 0; i--) {

            // Hold the value from the current iteration
            int temp = arr[i];

            // Set current index to be the current max value
            arr[i] = currentMax;

            // Get new max value
            currentMax = Math.max(currentMax, temp);

        }

        return arr;
    }

}
