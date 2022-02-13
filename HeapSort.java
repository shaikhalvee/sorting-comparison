package com.project;

public class HeapSort implements Sort {

	public void doSort(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			buildMinHeap(array, array.length, i);
		}
		for (int i = array.length - 1; i >= 0; i--) {
			int root = array[0];
			array[0] = array[i];
			array[i] = root;
			buildMinHeap(array, i, 0);
		}
	}

	private void buildMinHeap(int[] array, int heapLength, int index) {
		int rootIndex = index;
		int leftIndex = (index << 1) + 1;
		int rightIndex = (index << 1) + 2;
		if (leftIndex < heapLength && array[leftIndex] > array[rootIndex]) {
			rootIndex = leftIndex;
		}
		if (rightIndex < heapLength && array[rightIndex] > array[rootIndex]) {
			rootIndex = rightIndex;
		}
		if (rootIndex != index) {
			int swap = array[rootIndex];
			array[rootIndex] = array[index];
			array[index] = swap;
			buildMinHeap(array, heapLength, rootIndex);
		}
	}
}
