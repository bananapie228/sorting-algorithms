import java.util.Arrays;
import java.util.Random;

public class DeterministicSelect {

    public static int findKth(int[] arr, int k) {
        return select(Arrays.copyOf(arr, arr.length), k - 1);
    }

    private static int select(int[] arr, int k) {
        int n = arr.length;

        // Base case
        if (n <= 5) {
            Arrays.sort(arr);
            return arr[k];
        }

        // Get medians of groups of 5
        int groups = (n + 4) / 5;
        int[] medians = new int[groups];

        for (int i = 0; i < groups; i++) {
            int start = i * 5;
            int end = Math.min(start + 5, n);
            int[] group = Arrays.copyOfRange(arr, start, end);
            Arrays.sort(group);
            medians[i] = group[group.length / 2];
        }

        // Find median of medians
        int pivot = select(medians, medians.length / 2);

        // Partition counts
        int less = 0, equal = 0;
        for (int x : arr) {
            if (x < pivot) less++;
            else if (x == pivot) equal++;
        }

        if (k < less) {
            int[] smaller = new int[less];
            int idx = 0;
            for (int x : arr) if (x < pivot) smaller[idx++] = x;
            return select(smaller, k);
        } else if (k < less + equal) {
            return pivot;
        } else {
            int[] larger = new int[arr.length - less - equal];
            int idx = 0;
            for (int x : arr) if (x > pivot) larger[idx++] = x;
            return select(larger, k - less - equal);
        }
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("3rd smallest: " + findKth(arr, 3));
        System.out.println("5th smallest: " + findKth(arr, 5));

        Random rand = new Random();
        int trials = 100;
        int arraySize = 20;
        int maxValue = 100;
        boolean allPassed = true;

        for (int t = 0; t < trials; t++) {
            int[] randomArray = new int[arraySize];
            for (int i = 0; i < arraySize; i++) randomArray[i] = rand.nextInt(maxValue);

            for (int k = 1; k <= arraySize; k++) {
                int kthDeterministic = findKth(randomArray, k);

                int[] sortedCopy = Arrays.copyOf(randomArray, randomArray.length);
                Arrays.sort(sortedCopy);
                int kthExpected = sortedCopy[k - 1];

                if (kthDeterministic != kthExpected) {
                    System.out.println("Test failed");
                    allPassed = false;
                }
            }
        }

        if (allPassed) System.out.println("All trials passed!");
    }
}
