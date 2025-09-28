# QuickSort Algorithm in Java

This project implements **QuickSort**, a fast divide-and-conquer sorting algorithm in Java.


## Installation

1. Clone the repository:

bash
git clone https://github.com/bananapie228/sorting-algorithms/tree/quick-sort.git
Open the project in your IDE.

Compile and run:


# Usage
Prints original and sorted array.

Handles arrays with duplicates, empty arrays, single elements, and reverse-sorted arrays.

# Algorithm
Choose a pivot (commonly last element).

Partition array: smaller elements left, larger elements right.

Recursively sort left and right subarrays.

Tail recursion or smaller-first recursion can limit stack depth.

# Time Complexity:

# Case	Complexity
Best Case	O(n log n)
Average Case	O(n log n)
Worst Case	O(n²)

 # Edge Case Testing
Tested on:

Empty array

Single-element array

Array with duplicates

Reverse-sorted array

All identical elements

All tests pass successfully.

# Performance
QuickSort efficiently sorts large arrays.

Average complexity O(n log n).




# Deterministic Select (Median-of-Medians) in Java

This project implements **Deterministic Select**, an algorithm to find the **k-th smallest element** in an array efficiently without fully sorting it.



## Installation

1. Clone the repository:

# bash
git clone https://github.com/bananapie228/quick-sort.git
Open the project in your IDE.

Compile and run:


Find the k-th smallest element:


Handles arrays with duplicates, empty arrays, single elements, reverse-sorted arrays.

# Algorithm
Divide the array into groups of 5 elements.

Find the median of each group.

Recursively find the median of medians → pivot.

Partition array around pivot: elements < pivot, = pivot, > pivot.

Recurse only on the side containing the k-th element.

# Time Complexity:

Case	Complexity
Worst Case	O(n)
Average Case	O(n)

Edge Case & Random Testing
Tested with empty arrays, single-element arrays, duplicates, reverse-sorted arrays, and arrays with all identical elements.

Verified against Arrays.sort(arr)[k-1] across 100 random arrays.

# Performance
Guarantees O(n) worst-case time.

Ideal for finding medians, percentiles, or k-th order statistics without fully sorting the array.
