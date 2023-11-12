# Java Sorting Algorithm CLI

This Java project provides a Command Line Interface (CLI) for sorting arrays using different sorting algorithms. It allows you to input an array of integers and select a sorting algorithm of your choice.

## Prerequisites

Before running this project, ensure that you have the following software installed:

- Java Development Kit (JDK)

## Running Unit Tests

See [Running Tests](readmeTest.md)

## Usage
pre: Make a directory classes as a sibling to src

1. Make sure you are under the directory src/main/java

    ```
    cd src/main/java
    ```


2. Compile the Java code:

    ```
    javac -d ../../../classes Main.java
    ```

3. Run the application with the chosen sorting algorithm using the `-Dfactory` system property. You can specify any valid sorting algorithm name such as "bubble," "quick" etc.

    ```
    cd <back to dev root, where src and classses are subdirectories>
    java -Dfactory=<sorting_algorithm> -cp classes Main
    ```

   Replace `<sorting_algorithm>` with the name of the desired sorting algorithm.

4. Follow the on-screen instructions to input your array of integers.

5. The program will sort the array using the selected sorting algorithm and display the sorted result.

## Available Sorting Algorithms

- Bubble Sort
- Quick Sort
- (You can add more sorting algorithms by implementing a Factory Method, as explained below)

## Implementing Additional Sorting Algorithms

You can extend this project by implementing additional sorting algorithms using a Factory Method design pattern. To do so, follow these steps:

1. Create a new Java class for your sorting algorithm, e.g., `MySortAlgorithm.java`.

2. Implement the `ISort` interface in your sorting algorithm class.

3. Add your sorting algorithm's implementation within the `sort` method.

4. Modify the `SortingAlgorithmFactory.java` to include a case for your new sorting algorithm. For example:

    ```
    else if (algorithmName.equalsIgnoreCase("mySort")) {
        return new MySortAlgorithm<>();
    }
    ```

5. Now you can use your sorting algorithm by specifying `-Dfactory=mySort` when running the application.

## Example Usage

To run the program using a custom sorting algorithm named "mySort":
    
```    
java -Dfactory=mySort Main
```