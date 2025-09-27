import java.util.Random;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        testSortingCorrectness();

        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }


        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\n");
        printArray(numbers);
    }


    private static void mergeSort(int[] inputArr) {
        int inputLength = inputArr.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArr[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArr, leftHalf, rightHalf);
    }

    private static void merge (int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            }
            else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
    public static void testSortingCorrectness() {
        int[] randomArray = generateRandomArray(10);
        System.out.println("Original array (random): " + Arrays.toString(randomArray));

        int[] expected = Arrays.copyOf(randomArray, randomArray.length);
        Arrays.sort(expected);
        MergeSort.mergeSort(randomArray);
        System.out.println(Arrays.toString(randomArray));

        assert Arrays.equals(randomArray, expected) : "Test failed: Arrays do not match!";
        System.out.println("Test passed: Correctly sorted random array.");
    }
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 10);
        }
        return arr;
    }


}



