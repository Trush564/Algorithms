package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MergeSortTest {
    @Test
    public void testMergeSort(){
        Integer[] sourceArray=new Integer[]{-5,4,10,2,1,8,-5,0};
        Integer[] expectArray = new Integer[]{-5,-5,0,1,2,4,8,10};
        MergeSort<Integer>mergeSortAlg=new MergeSort<>(sourceArray);
        mergeSortAlg.mergeSort();
        assertThat(mergeSortAlg.getArray()).isEqualTo(expectArray);

    }
    // Завдання 1: сортування за спаданням
    @Test
    public void testMergeSortDescending() {
        Integer[] sourceArray = new Integer[100];
        Random rand = new Random();
        for (int i = 0; i < sourceArray.length; i++) {
            sourceArray[i] = rand.nextInt(1000);
        }
        Integer[] expectedArray = Arrays.copyOf(sourceArray, sourceArray.length);
        Arrays.sort(expectedArray, (a, b) -> b - a);

        MergeSort<Integer> sorter = new MergeSort<>(sourceArray);
        sorter.mergeSortDescending();

        assertThat(sorter.getArray()).isEqualTo(expectedArray);
    }

    // Завдання 2: сортування в діапазоні
    @Test
    public void testMergeSortInRange() {
        Integer[] sourceArray = new Integer[]{5, 9, 3, 8, 2, 7, 1, 6, 4};
        MergeSort<Integer> sorter = new MergeSort<>(sourceArray);
        sorter.mergeSortInRange(2, 6, true); // сортуємо за спаданням з індексу 2 до 6

        Integer[] expected = new Integer[]{5, 9, 8, 7, 3, 2, 1, 6, 4};
        assertThat(sorter.getArray()).isEqualTo(expected);
    }

    // Завдання 3: порівняння часу виконання
    @Test
    public void testPerformanceComparison() {
        int size = 100000;
        Integer[] arrayForMerge = new Integer[size];
        Integer[] arrayForQuick = new Integer[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int val = rand.nextInt(1000000);
            arrayForMerge[i] = val;
            arrayForQuick[i] = val;
        }

        long startMerge = System.currentTimeMillis();
        MergeSort<Integer> mergeSorter = new MergeSort<>(arrayForMerge);
        mergeSorter.mergeSort();
        long endMerge = System.currentTimeMillis();

        long startQuick = System.currentTimeMillis();
        Arrays.sort(arrayForQuick);
        long endQuick = System.currentTimeMillis();

        System.out.println("Merge Sort time: " + (endMerge - startMerge) + " ms");
        System.out.println("Quick Sort time: " + (endQuick - startQuick) + " ms");

        assertThat(mergeSorter.getArray()).isEqualTo(arrayForQuick);
    }
}
