package sort;

import dataStructures.Heap;

public class Sort {

	public static void main(String[] args) {
		CountingSort sort = new CountingSort();
		int[] arr = { 1, 5, 6, 2, 1, 4, 1 };
		puts(sort.countingSort(arr));

	}

	public  static void puts(int[] sorted, int[] unsorted) {
		for (int i = 0; i < unsorted.length; i++) {
			System.out.print(sorted[i] + ": " + unsorted[i]);
		}
		System.out.println();

	}

	public static void puts(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}



}
