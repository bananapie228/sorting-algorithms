import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 3, 9, 10, 13};

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
}
