# Running Tests

This project includes JUnit tests for various sorting algorithms. Follow the steps below to run the tests:

## Prerequisites

Make sure you have the following installed on your system:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/install/)
- Read the [Java Sorting Algorithm CLI](readme.md) page first 
## Steps

1. Clone/Unzip the repository to your local machine:

    ```bash
    git clone https://github.com/skuma251/ser515public.git
    ```

2. Navigate to the project directory:

    ```bash
    cd Sorting
    ```

3. Compile the project and run the tests using Gradle:

    ```bash
    ./gradlew test
    ```

   This will execute all the tests and provide a summary of the results.

## Running Individual Test Suites

If you want to run tests for a specific sorting algorithm, you can use the following commands:

### Run Bubble Sort Tests

```bash
./gradlew test --tests BubbleSortTest
```

### Run Quick Sort Tests

```bash
./gradlew test --tests QuickSortTest
```

