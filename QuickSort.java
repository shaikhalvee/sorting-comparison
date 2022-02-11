package com.project;

public class QuickSort {

	public static void doQuickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int partitionIndex = partitionNew(array, left, right);
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

	private static int partitionNew(int[] array, int left, int right) {
		int pivot = array[right];
		int l = left, r = right - 1;
		int swap;
		while (l <= r) {
			while (l < array.length && array[l] <= pivot) {
				l++;
			}
			int leftBig = array[l];
			while (r > 0 && array[r] > pivot) {
				r--;
			}
			int rightBig = array[r];
			swap = array[l];
			array[l] = array[r];
			array[r] = swap;
			l++;
			r--;
		}
		swap = array[right];
		array[right] = array[l];
		array[l] = swap;
		return 0;
	}
}
