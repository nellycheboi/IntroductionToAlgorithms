package sort;

/**
 * Counting sort assumes that each of the n input elements is an integer in the
 * range 0 to k, for some integer k. When k = O(n), the sort runs in 0(n) time.
 * Counting sort determines, for each input element x, the number of elements
 * less than x. It uses this information to place element x directly into its
 * position in the output array.
 * 
 * An important property of counting sort is that it is stable: numbers with the
 * same value appear in the output array in the same order as they do in the
 * input array. That is, it breaks ties between two numbers by the rule that
 * whichever number appears first in the input array appears first in the output
 * array. Normally, the property of stability is important only when satellite
 * data are carried around with the element being sorted.
 * 
 * @author Nelly
 *
 */
public class CountingSort {
	public int[] countingSort(int[] arr) {
		return sort(arr);
	}

	// 0(maximum + n)
	// In practice, we usually use counting sort when we have k D O.n/, in
	// which case the running time is 0(n)
	private int[] sort(int[] arr) {
		int maximum = maximum(arr);
		int[] frequencyCount = new int[maximum + 1];
		;
		int[] sorted = new int[arr.length];
		// 0(n)
		for (int i = 0; i < arr.length; i++) {
			frequencyCount[arr[i]]++;
		}
		// 0(maximum)
		for (int i = 1; i < frequencyCount.length; i++) {
			frequencyCount[i] = frequencyCount[i] + frequencyCount[i - 1];
		}
		// 0(n)
		for (int i = arr.length - 1; i >= 0; i--) {

			sorted[frequencyCount[arr[i]] - 1] = arr[i];
			frequencyCount[arr[i]]--;
		}
		return sorted;
	}

	private int maximum(int[] arr) {
		int max = arr[0];
		// decrement to 1 for stability :: numbers with the
		// same value appear in the output array in the same order as they do in
		// the
		// input array.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
