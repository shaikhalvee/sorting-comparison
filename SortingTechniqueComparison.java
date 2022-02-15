package com.project;

import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.IntStream;

public class SortingTechniqueComparison {

	public static void main(String[] args) {

//		int[] ara = {3, 0, -4, 2, 7, 5, 4, 34, -3, -1, 0, 8, 9, 22, 11, 2, 7, 8};
//		int[] ara2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

		// initialize arrays
		String[] sortingAlgoList = {"Insertion Sort", "Heap Sort", "Merge Sort", "Modified Quick Sort", "Quick Sort"};
		String[] inputTypes = {"Normal", "Sorted", "Reverse Sorted"};
		int[] ranges = {1000, 2000, 4000, 5000, 8000, 10000, 20000,
				30000, 40000, 50000, 80000, 100000};
		int[][] inputArrays = new int[ranges.length][];
		for (int i = 0; i < inputArrays.length; i++) {
			inputArrays[i] = new int[ranges[i]];
			inputArrays[i] = IntStream.generate(
					() -> new Random().nextInt()
			).limit(ranges[i]).toArray();
		}

		HashMap<String, HashMap<String, ArrayList<Pair<Integer, Long>>>> timeTaken = calculateRuntimes(inputArrays, sortingAlgoList, inputTypes);
		writeOutputInFile(timeTaken, sortingAlgoList, inputTypes);

//        InsertionSort.doInsertionSort(ara);
//		QuickSort quickSort = new QuickSort();
//		quickSort.doSort(ara);
//        ModifiedQuickSort modifiedQuickSort = new ModifiedQuickSort();
//		modifiedQuickSort.doSort(ara);
//		HeapSort.doHeapSort(ara);
//		System.out.println(Arrays.toString(ara));
	}

	private static HashMap<String, HashMap<String, ArrayList<Pair<Integer, Long>>>>
	calculateRuntimes(int[][] inputArrays,
	                  String[] sortingAlgoList,
	                  String[] inputTypes) {
		// initialize strings
		Sort[] sortingMethods = {new InsertionSort(), new HeapSort(),
				new MergeSort(), new ModifiedQuickSort(), new QuickSort()};
		// initialize runtime matrix
		HashMap<String, HashMap<String, ArrayList<Pair<Integer, Long>>>> runtimeMatrix = new HashMap<>();
		for (String sortingAlgo : sortingAlgoList) {
			HashMap<String, ArrayList<Pair<Integer, Long>>> typeMatrix = new HashMap<>();
			for (String inputType : inputTypes) {
				typeMatrix.put(inputType, new ArrayList<>());
			}
			runtimeMatrix.put(sortingAlgo, typeMatrix);
		}
		// do sorting & calculate runtime
		for (int i = 0; i < sortingMethods.length; i++) {
			// input is copied for each algo so that same input is used for each algo
			int[][] arrayCopy = inputMatrixClone(inputArrays);
			// getting sorting type matrix before getting into it
			HashMap<String, ArrayList<Pair<Integer, Long>>> sortingTypeMap = runtimeMatrix.get(sortingAlgoList[i]);
			for (int j = 0; j < inputTypes.length; j++) {
				ArrayList<Pair<Integer, Long>> runtimeMap = sortingTypeMap.get(inputTypes[j]);
				for (int[] currentInputs : arrayCopy) {
					if (j == inputTypes.length - 1) {
						Collections.reverse(Arrays.asList(currentInputs));
					}
					Long startTime = System.nanoTime();
					sortingMethods[i].doSort(currentInputs);
					Long endTime = System.nanoTime();
					Long totalTimeTaken = endTime - startTime;
					Pair<Integer, Long> value = new Pair<>(currentInputs.length, totalTimeTaken);
					runtimeMap.add(value);
				}
			}
		}
		return runtimeMatrix;
	}

	private static int[][] inputMatrixClone(int[][] inputArrays) {
		int[][] arrayCopy = new int[inputArrays.length][];
		for (int p = 0; p < inputArrays.length; p++) {
			arrayCopy[p] = new int[inputArrays[p].length];
			System.arraycopy(inputArrays[p], 0, arrayCopy[p], 0, inputArrays[p].length);
		}
		return arrayCopy;
	}

	private static void writeOutputInFile(HashMap<String, HashMap<String, ArrayList<Pair<Integer, Long>>>> timeTakenMatrix,
	                                      String[] sortingAlgoList,
	                                      String[] inputTypes) {
		File outputFile = new File("output_runtime.csv");
		try {
			boolean newFile = outputFile.createNewFile();
			if (!newFile) {
				outputFile.delete();
				outputFile.createNewFile();
			}
			PrintWriter printWriter = new PrintWriter(outputFile);
			String[] dataToWrite = {"Sorting Algorithm", "Input Array Types",
					"Array Size", "Time Taken in NanoSecond"};
			for (int i = 0; i < dataToWrite.length; i++) {
				printWriter.print(dataToWrite[i]);
				if (i != dataToWrite.length - 1) {
					printWriter.print(",");
				}
			}
			printWriter.println();
			for (String algorithm : sortingAlgoList) {
				HashMap<String, ArrayList<Pair<Integer, Long>>> inputStyleSet = timeTakenMatrix.get(algorithm);
				for (String inputStyle : inputTypes) {
					ArrayList<Pair<Integer, Long>> dataMatrixForEachInputStyle = inputStyleSet.get(inputStyle);
					for (Pair<Integer, Long> dataForCurrentInputSet : dataMatrixForEachInputStyle) {
						printWriter.println(algorithm + "," +
								inputStyle + "," +
								dataForCurrentInputSet.getKey() + "," +
								dataForCurrentInputSet.getValue()
						);
					}
				}
			}
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
