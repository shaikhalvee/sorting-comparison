package com.project;

public class InsertionSort {
	public static void doInsertionSort(int[] sortedArray) {
		for (int i = 1; i < sortedArray.length; i++) {
			int j = i - 1;
			int key = sortedArray[i];
			while (j >= 0 && key < sortedArray[j]) {
				sortedArray[j + 1] = sortedArray[j--];
			}
			sortedArray[j + 1] = key;
		}
	}
}
