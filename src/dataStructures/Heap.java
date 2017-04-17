package dataStructures;

/**
 * The heap property: Max heap arr[parent[i]] >= arr[i] tha is teh value of a
 * node is at most the value of its parent thus the largest element of the heap
 * is stored at the root and the subtree rooted at the node contains no values
 * larger than that that contained at the node
 * 
 * @author Nelly
 *
 */
public class Heap {

	public int[] heapSort(int[] arr) {

		return sort(arr);

	}

	private int heapMaximum(int[] arr) {
		buildHeap(arr);
		return arr[0];
	}

	private int[] heapInsert(int[] arr, int key) {
		int[] arr2 = new int[arr.length + 1];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		arr2[arr2.length - 1] = key;
		return increaseHeapKey(arr2, arr2.length - 1, key);
	}

	// O(lg(n)) updating only the root
	private int[] increaseHeapKey(int[] arr, int i, int key) {
		if (key < arr[i]) {
			throw new IllegalArgumentException("key smaller than current key");
		}
		arr[i] = key;

		while (i >= 1 && arr[parent(i)] < key) {
			int temp = arr[i];
			arr[i] = arr[i - 1];
			arr[i - 1] = temp;
			i--;
		}
		return arr;
	}

	private int parent(int i) {

		return i == 0 ? 0 : i / 2;
	}

	public int[] sort(int[] arr) {
		buildHeap(arr);

		int len = arr.length - 1;
		for (int i = 0; i <= len; i++) {
			int temp = arr[len - 1];
			buildHeap(arr, i);

		}
		return arr;
	}

	/**
	 * each maxHeapify take 0(lg n) and we are making O(n) such calls
	 */
	private int[] buildHeap(int[] arr, int index) {

		for (int i = (arr.length + index) / 2; i >= 0; i--) {
			maxHeapify(arr, i, index);
		}
		return arr;
	}

	private int[] buildHeap(int[] arr) {
		for (int i = (arr.length) / 2; i >= 0; i--) {
			maxHeapify(arr, i);
		}
		return arr;
	}

	/**
	 * the children subtrees each has the size at most 2/3n the worst case when
	 * the the bottom level of the tree is exactly half full the running time of
	 * max heapify is therefore T(n) <= T(2/3N)+O(1) a = 1; b =3/2; f(n/0) =
	 * O(1) n^lg(3/2,1) = 0 , n^0 = 1 case 2: T(n)= 0(n^(lg(3/2,1)); T(n) =
	 * 0(n^lg(3/2,1)lg(n)) = 0(lg n)
	 * 
	 * @param arr
	 * @param i
	 * @return
	 */
	private int[] maxHeapify(int[] arr, int i) {
		if (i >= arr.length || i < 0) {
			return arr;
		}
		int heapSize = arr.length - 1;
		int leftIndex = left(i);
		int rightIndex = right(i);
		int largest = i;

		if (leftIndex <= heapSize && arr[leftIndex] > arr[i]) {
			largest = leftIndex;
		}
		if (rightIndex <= heapSize && arr[rightIndex] > arr[largest]) {
			largest = rightIndex;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			return maxHeapify(arr, largest);
		}
		return arr;
	}

	private int[] maxHeapify(int[] arr, int i, int offset) {
		if (i >= arr.length || i < offset) {
			return arr;
		}
		int heapSize = arr.length - 1;
		int leftIndex = left(i - offset) + offset;
		int rightIndex = right(i - offset) + offset;
		int largest = i;

		if (leftIndex <= heapSize && arr[leftIndex] > arr[i]) {
			largest = leftIndex;
		}
		if (rightIndex <= heapSize && arr[rightIndex] > arr[largest]) {
			largest = rightIndex;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			return maxHeapify(arr, largest, offset);
		}
		return arr;
	}

	/**
	 * given an index this method returns the right index of heap in its array
	 * representation
	 */
	private int right(int i) {
		if (i == 0) {
			return 2;
		} else if (i == 1) {
			return 4;
		}
		return 2 * i;
	}

	/**
	 * given an index(root) this method returns the left child in the heap
	 * implemented as an array
	 */
	private int left(int i) {
		if (i == 0) {
			return 1;
		} else if (i == 1) {
			return 3;
		}
		return 2 * i - 1;
	}

}
