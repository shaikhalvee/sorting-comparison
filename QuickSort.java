package com.project;

public class QuickSort implements Sort {

	public void doSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(array, left, right);
			quickSort(array, left, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, right);
		}
	}

	private int partition(int[] array, int left, int right) {
		// taking last or rightmost index as pivot
		int pivot = array[right];
		int index = left - 1;
		int swap;
		for (int i = left; i < right; i++) {
			if (array[i] <= pivot) {
				swap = array[++index];
				array[index] = array[i];
				array[i] = swap;
//				index++;
			}
		}
		swap = array[index + 1];
		array[index + 1] = array[right];
		array[right] = swap;
		return index + 1;
	}

}
