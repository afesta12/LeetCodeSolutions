public class MountainArray {

    /**
     * Given an array of integers arr, return true if and only if it is a valid mountain array.
     *
     * @param arr the array
     * @return true if arr is a mountain array
     */
    public boolean mountainArray(int[] arr) {

        // Problem states if length < 3, then the array cannot be a mountain array, so return false
        int len = arr.length;

        if(len < 3) return false;

        // Index will keep track of where the "top of the mountain is"
        int index = 0;

        for(int i = 1; i < len; i++) {

            if(arr[i] > arr[i - 1]) index++;
            else if(arr[i] == arr[i - 1]) return false;

            // the loop will terminate once the previous index > current index && index will mark that spot
            else if(arr[i] < arr[i - 1]) break;

        }

        // If the index is 0 at this point, then the array cannot be a mountain array, so return false
        // ex {9, 8, 7, 6, 5}, the loop will terminate on the first iteration, so arr cannot be a mountain array
        if(index == 0) return false;

        for(int i = index + 1; i < len; i++) {

            if(!(arr[i] < arr[i - 1])) return false;

        }

        // If index == arr.length - 1, the entire array is just increasing, so return false
        return index != len - 1;
    }

}
