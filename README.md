
## MergeSort Algorithm in Java

This project implements the **MergeSort** algorithm in **Java**, demonstrating the divide-and-conquer approach to sorting arrays. The code includes performance testing and correctness verification for various input cases, including random and adversarial arrays.



## Installation Instructions

To set up and run this project on your local machine, follow these steps:

1. **Clone the repository**:
  
   git clone https://github.com/bananapie228/sorting-algorithms.git


2. **Navigate to the project folder**:

   cd merge-sort-java

3. **Open the project** in your preferred IDE 
4. **Compile** and **run** the `MergeSort.java` file. 

## Usage

To test the **MergeSort** algorithm:

1. **Run the `MergeSort` class**.
2. The program will generate a random array, sort it using the **MergeSort** algorithm, and print the sorted array.

Example output:

```
Original array: [38, 27, 43, 3, 9, 82, 10]
Sorted array: [3, 9, 10, 27, 38, 43, 82]
```

## Algorithm Explanation

**MergeSort** is a classic **divide-and-conquer** algorithm that works as follows:

1. **Divide**: The array is recursively divided into two halves until each subarray contains a single element or no elements.
2. **Conquer**: Each of these subarrays is sorted by recursively dividing and merging.
3. **Combine**: Once the subarrays are sorted, they are merged back together to form the sorted array.

### Time Complexity:

**Best Case**: O(n log n)
**Worst Case**: O(n log n)
**Average Case**: O(n log n)

### Space Complexity:

* O(n) due to the auxiliary arrays used in merging.

**MergeSort** is stable, meaning that it preserves the relative order of equal elements.

## Testing

This project includes tests for:

* **Sorting Correctness**: Verifies that the algorithm correctly sorts random arrays and adversarial arrays (e.g., reverse sorted arrays).
* **Edge Case Handling**: Ensures that the algorithm handles edge cases such as empty arrays or arrays with a single element.

#### Example Tests:

* **Random arrays**: Verifying that MergeSort correctly sorts randomly shuffled arrays.
* **Reverse-sorted arrays**: Ensuring that the algorithm handles the worst-case scenario where the array is sorted in reverse order.
* **Single-element arrays**: Verifying that arrays with one element are handled correctly.


