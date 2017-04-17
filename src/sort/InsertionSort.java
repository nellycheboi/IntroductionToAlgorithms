package sort;

public class InsertionSort {

	public int[] insertionSort(int[] arr) {
		return sort(arr);
	}

	private int[] sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) { // O(N-1)
			int key = arr[i]; // O(1)
			int checker = i - 1; // O(1)
			while (checker >= 0 && arr[checker] > key) { // sum upto i
															// arithmetic series
				arr[checker + 1] = arr[checker]; // O(1)
				checker--; // O(1)
			}
			arr[checker + 1] = key; // O(1)

		}
		return arr;
	}

	private String sort(String str) {
		char[] chars = str.toCharArray();
		for (int i = 1; i < chars.length; i++) {
			char key = chars[i];
			int checker = i - 1;
			while (checker >= 0 && chars[checker] > key) {
				chars[checker + 1] = chars[checker];
				checker--;

			}
			chars[checker + 1] = key;

		}
		return new String(chars);
	}
}
