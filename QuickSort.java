package com.project;

public class QuickSort {

	public static void doQuickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(array, left, right);
			quickSort(array, left, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		// taking last or rightmost index as pivot
		int pivot = array[right];
		int index = left;
		int swap;
		for (int i = left; i < right; i++) {
			if (array[i] <= pivot) {
				swap = array[index];
				array[index] = array[i];
				array[i] = swap;
				index++;
			}
		}
		swap = array[index];
		array[index] = array[right];
		array[right] = swap;
		return index;
	}

}
