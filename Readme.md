## Files

Please go to the folder where codes are.

	cd com/project/


## JDK Version

JDK version should be exactly 1.8. JDK <= 1.7 or JDK < 1.8 will not work.

	$ java -version
	java version "1.8.0_221"
	Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
	Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)


## Command to run the code

Please run the code as instructed below

	javac SortingTechniqueComparison.java Sort.java InsertionSort.java HeapSort.java MergeSort.java ModifiedQuickSort.java QuickSort.java
	
	java -classpath ../.. com.project.SortingTechniqueComparison

## Output files

Output will be in CSV files namely `output_runtime.csv`. You can save it as `output_runtime.xlsx` to utilize the functionalities of microsoft excel sheet.
