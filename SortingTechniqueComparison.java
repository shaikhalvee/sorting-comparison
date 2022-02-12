package com.project;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SortingTechniqueComparison {

	public static void main(String[] args) {

		int[] ara = {3, 0, -4, 2, 7, 5, 4, 34, -3, -1, 0, 8, 9, 22, 11, 2, 7, 8};
		int[] ara2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};


		// initialize arrays
		int[] ranges = {1000, 2000, 4000, 5000, 10000, 20000, 40000,
				50000, 60000, 80000, 100000, 500000, 1000000, 3000000,
				5000000,8000000,10000000};
		int[][] inputArrays = new int[ranges.length][];
		for (int i = 0; i < inputArrays.length; i++) {
			inputArrays[i] = new int[ranges[i]];
			inputArrays[i] = IntStream.generate(()->new Random().nextInt()).limit(ranges[i]).toArray();
		}


//        InsertionSort.doInsertionSort(ara);
//		QuickSort.doQuickSort(ara);
//        ModifiedQuickSort.doModifiedQuickSort(ara);
//		HeapSort.doHeapSort(ara);
//		System.out.println(Arrays.toString(ara));
	}

}
