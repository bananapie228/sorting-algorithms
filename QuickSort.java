import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 3, 9, 10, 13};
        testQuickSort();

        // Print original array
        System.out.println("Unsorted Array: " + Arrays.toString(array));

        // Sort array using QuickSort
        quickSort(array, 0, array.length - 1);

        // Print sorted array
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    // Recursive QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after pivot
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method using last element as pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        // Move elements smaller than pivot to left
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    private static void testQuickSort() {
        int[][] testArrays = {
                {},                  // Empty array
                {4},                // Single element
                {3, 3, 5, 2, 5},     // Duplicates
                {10, 9, 8},    // Reverse sorted
                {1, 1, 1, 1},        // All identical

        };

        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];     // Pick each test array
            int[] copy = arr.clone();      // Make a copy to sort for comparison
            Arrays.sort(copy);             // Built-in sort for expected result

            quickSort(arr, 0, arr.length - 1);  // Sort with QuickSort

            // Check if QuickSort sorted the array correctly
            assert Arrays.equals(arr, copy) : "Test failed on array: " + Arrays.toString(copy);
        }

        System.out.println("QuickSort edge cases passed");
    }
}
