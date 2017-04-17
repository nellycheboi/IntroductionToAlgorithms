package sort;

import java.util.Random;
/*
 * The running time depends if the partition is balanced. 
 * If the partition is unbalanced, it can run as slow as insertion sort and 
 * as fast as merge sort of the partition is balanced.
 * Worse Case partitioning occurs when the partitioning routine produces one subproblem with n-1 elements 
 * and one 0 elements. 
 * Recursive call on array of 0 elements just returns T(0) = O(1)
 * unbalanced partition the becomes
 * T(n) =  T(n-1)+T(0)+0(n)
 *  	= T(n-1) + 0(n) --arithmetic series 
 *  T(n) = 0(n^2)
 *  Thus if the partition is maximumly unbalanced the running time is no better than insertion. 
 *  This occurs when the input is already sorted - a common situation in which insertion sort runs in O(n)
 *  time
 * BEST CASE PARTITIONING
 * in most even possible split, partition produces two subproblems each of size no more than n/2
 * in this case quick sort runs much faster 
 * the recurrence running time is then
 * T(n) = 2T(n/2) + 0(n) by case 2 of the master theorem a = 2; b = 2; n^lg(2,2) = 1
 * T(n) = 0(n lg(n))
 * Suppose, for example, that the partitioning algorithm always produces a 9-to-1
*  proportional split, which at first blush seems quite unbalanced. We then obtain the
 * recurrence
 * T(n) = T(9n/10) + T(1n/10) +c (n)
 * Notice that every level of the tree has cost cn, until the recursion reaches a boundary
* condition at depth lg(10, n) = 0(lg n), and then the levels have cost at most cn.
* The recursion terminates at depth lg(10/9, n) = 0(lg n). The total cost of quicksort
* is therefore O(n lg n) Thus, with a 9-to-1 proportional split at every level of
* recursion, which intuitively seems quite unbalanced, quicksort runs in O(n lg n)
* time—asymptotically the same as if the split were right down the middle. Indeed,
* even a 99-to-1 split yields anO(n lg n) running time. In fact, any split of constant
* proportionality yields a recursion tree of depth lg n where the cost at each level
* is O.n/. The running time is therefore O(nlgn) whenever the split has constant
* proportionality.
* 
* The combination of the bad split followed by the good split produces three subarrays
* of sizes 0, (n-1)/2 -1, (n -1)/2 at a combined partitioning cost
* of 0(n) + 0(n -1) = 0(n) Certainly, this situation is no worse than that in
*  Intuitively,
* the 0(n - 1) cost of the bad split can be absorbed into the 0(n) cost of the good
* split, and the resulting split is good. Thus, the running time of quicksort, when levels
* alternate between good and bad splits, is like the running time for good splits
* alone: still O(nlgn), but with a slightly larger constant hidden by the O-notation.
 */

public class QuickSort {
	public int[] quickSort(int[] arr) {

		return quickSort(arr, 0, arr.length - 1);
	}

	private int[] quickSort(int[] arr, int left, int right) {
		// int random_index = new Random(left).nextInt();

		// int splitIndex = partition(arr, left, right);
		int splitIndex = randomizedPartition(arr, left, right);
		System.out.println(splitIndex);
		if (right - left <= 1) {
			return arr;
		}
		if (left < right) {
			quickSort(arr, left, splitIndex - 1);
		}
		if (right > left) {
			quickSort(arr, splitIndex, right);
		}
		return arr;
	}

	private void puts(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

	/*
	 * Many people regard the resulting randomized version of quicksort as the
	 * sorting algorithm of choice for large enough inputs. Because we randomly
	 * choose the pivot element, we expect the split of the input array to be
	 * reasonably well balanced on average.
	 */
	private int randomizedPartition(int[] arr, int left, int right) {
		if (right - left > 1 && left > 0) {

			int random_index = new Random().nextInt(right - left) + left;

			int temp = arr[right];
			arr[right] = arr[random_index];
			arr[random_index] = temp;
		}

		return partition(arr, left, right);
	}

	/*
	 * Key of the algorithm: partition the array such that anything less than
	 * the pivot is on the left side of the pivot and anything larger on the
	 * right of the pivot Returns the partition index for the next iteration the
	 * running time is 0(n) where n = right-left+1
	 */
	private int partition(int[] arr, int left, int right) {
		int key = arr[right];
		int leftIndexer = left - 1;
		int rightIndexer = left;
		while (rightIndexer < right) {

			if (arr[rightIndexer] < key) {
				leftIndexer++;
				int temp = arr[rightIndexer];
				arr[rightIndexer] = arr[leftIndexer];
				arr[leftIndexer] = temp;
			}

			rightIndexer++;
		}
		arr[rightIndexer] = arr[leftIndexer + 1];
		arr[leftIndexer + 1] = key;

		return leftIndexer + 1;
	}
}
