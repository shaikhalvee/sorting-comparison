package com.project;

public class ModifiedQuickSort implements Sort {
	private final InsertionSort insertionSort;

	ModifiedQuickSort() {
		this.insertionSort = new InsertionSort();
	}

	public void doSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private void quickSort(int[] array, int left, int right) {
		if (left + 8 < right) {
			int partitionIndex = partitionWithMedian(array, left, right);
			quickSort(array, left, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, right);
		} else {
			insertionSort.doSort(array);
		}
	}

	private static int partitionWithMedian(int[] array, int left, int right) {
		int pivot = medianOfArray(array, left, right);
		int leftIndex = left;
		int rightIndex = right - 2;
		int swap;
		for (; ; ) {
//			while (array[leftIndex++])
			// not using leftIndex++ because, current leftIndex has already been
			// compared in the median calculations
			while (array[++leftIndex] < pivot) ;
			while (rightIndex > 0 && array[--rightIndex] > pivot) ;
			if (leftIndex < rightIndex) {
				swap = array[leftIndex];
				array[leftIndex] = array[rightIndex];
				array[rightIndex] = swap;
			} else {
				break;
			}
		}
		swap = array[leftIndex];
		array[leftIndex] = array[right - 1];
		array[right - 1] = swap;
		return leftIndex;
	}

	private static int medianOfArray(int[] array, int left, int right) {
		int median = left / 2 + right / 2;
		int smaller, middle, larger;
		if (array[left] <= array[right]) {
			if (array[left] <= array[median]) {
				smaller = array[left];
				if (array[median] <= array[right]) {
					middle = array[median];
					larger = array[right];
				} else {
					middle = array[right];
					larger = array[median];
				}
			} else {
				middle = array[left];
				smaller = array[median];
				larger = array[right];
			}
		} else {
			if (array[median] <= array[right]) {
				smaller = array[median];
				middle = array[right];
				larger = array[left];
			} else if (array[median] <= array[left]) {
				smaller = array[right];
				middle = array[median];
				larger = array[left];
			} else {
				smaller = array[right];
				middle = array[left];
				larger = array[median];
			}
		}
		array[left] = smaller;
		array[right] = larger;

		// setting pivot at right - 1
		int temp = array[right - 1];
		array[right - 1] = middle;
		array[median] = temp;
		return middle;
	}

}
