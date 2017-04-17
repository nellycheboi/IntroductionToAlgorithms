package sort;

public class MergeSort {
	public int[] mergeSort(int[] arr) {
		return sort(arr);
	}

	private int[] sort(int[] list) {
		if (list.length == 1) {
			return list;
		}
		int[] left = new int[list.length / 2];
		int[] right = new int[list.length - left.length];
		System.arraycopy(list, 0, left, 0, left.length);
		System.arraycopy(list, left.length, right, 0, right.length);
		sort(left);
		sort(right);
		merge(left, right, list);
		return list;

	}

	private void merge(int[] left, int[] right, int[] list) {
		int i = 0;
		int j = 0;
		int z = 0;
		while (left.length - 1 >= i && right.length - 1 >= j) {
			if (left[i] <= right[j]) {
				list[z] = left[i];
				i++;
			} else {
				list[z] = right[j];
				j++;
			}
			z++;
		}
		System.arraycopy(left, i, list, z, left.length - i);
		System.arraycopy(right, j, list, z, right.length - j);
	}

}
