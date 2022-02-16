package com.project;

import java.util.Arrays;
import java.util.Scanner;

public class Temp {
	public static void main(String[] args) {
		int[] ara = {3, 0, -4, 2, 7, 5, 4, 34, -3, -1, 0, 8, 9, 22, 11, 2, 7, 8};
		HeapSort heapSort = new HeapSort();
//		heapSort.doSort(ara);
		QuickSort quickSort = new QuickSort();
		quickSort.doSort(ara);
		ModifiedQuickSort modifiedQuickSort = new ModifiedQuickSort();
//		modifiedQuickSort.doSort(ara);
		System.out.println(Arrays.toString(ara));
	}

	private static void medianOfArray(int a, int b, int c) {
		int smaller, middle, larger;
		if (a <= c) {
			if (a <= b) {
				smaller = a;
				if (b <= c) {
					middle = b;
					larger = c;
				} else {
					middle = c;
					larger = b;
				}
			} else {
				middle = a;
				smaller = b;
				larger = c;
			}
		} else {
			if (b <= c) {
				smaller = b;
				middle = c;
				larger = a;
			} else if (b <= a) {
				smaller = c;
				middle = b;
				larger = a;
			} else {
				smaller = c;
				middle = a;
				larger = b;
			}
		}
		System.out.println(smaller);
		System.out.println(middle);
		System.out.println(larger);
	}
}
