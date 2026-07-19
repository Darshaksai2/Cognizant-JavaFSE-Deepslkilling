# Module 2 - Algorithmic and Data Structures Complexity Evaluations

## Exercise 1: Inventory System Data Token Strategies[cite: 9]
* **ArrayList vs HashMap Choice**: While an `ArrayList` performs addition in $O(1)$, searching or updating a record by its identifier key takes $O(n)$ due to matching array iterations[cite: 9]. A `HashMap` provides constant time parameters ($O(1)$) for addition, update, and deletion because hash functions map directly to specific bucket slots[cite: 9].
* **Optimization Bounds**: Implement intelligent bucket rehashing policies and choose prime numerical sizes to reduce potential element collusions.

## Exercise 2 & 6: Search Breakdowns[cite: 9]
* **Big O Significance**: Asymptotic notations measure how an algorithm's performance scales relative to input growth sizes ($n$), ignoring minor localized clock variations[cite: 9].
* **Scenarios Compared**:
  * **Linear Search**: Best Case: $O(1)$ (found at element zero), Worst/Average Case: $O(n)$[cite: 9].
  * **Binary Search**: Best Case: $O(1)$ (found exactly at middle pivot), Worst/Average Case: $O(\log n)$[cite: 9].

## Exercise 3: Sorting Paradigm Metrics[cite: 9]
* **Bubble Sort**: Compares adjacent pairs repeatedly. Average & Worst performance is $O(n^2)$[cite: 9].
* **Quick Sort**: Divides arrays using dynamic pivot points. Average execution performs at $O(n \log n)$[cite: 9].
* **Preference Reason**: Quick Sort is an in-place divide-and-conquer algorithm with significantly less overhead and memory tracking requirements than Bubble Sort[cite: 9].

## Exercise 4 & 5: Static Memory Arrays vs Dynamic Linked Lists[cite: 9]
* **Memory Management**: Arrays store elements in a contiguous block of memory, allowing for instant index lookups ($O(1)$)[cite: 9]. However, this structure requires expensive array scaling and element shifting operations when inserting or deleting elements ($O(n)$)[cite: 9].
* **Linked Lists**: Elements are linked via pointers, allowing for easy, dynamic insertions or deletions ($O(1)$)[cite: 9]. However, finding specific elements requires traveling sequentially down the list from the beginning node ($O(n)$)[cite: 9].