package com.project;

import java.util.Arrays;

public class SortingTechniqueComparison {

	public static void main(String[] args) {

		int[] ara = {3, 0, -4, 2, 7, 5, 4, 34, -3, -1, 0, 8, 9, 22, 11, 2, 7, 8};
		int[] ara2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//        InsertionSort.doInsertionSort(ara);
//		QuickSort.doQuickSort(ara);
        ModifiedQuickSort.doModifiedQuickSort(ara);
		System.out.println(Arrays.toString(ara));
	}

}
