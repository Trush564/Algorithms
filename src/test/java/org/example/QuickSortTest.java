package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuickSortTest {

    @Test
    public void testQuickSort(){
        Integer [] sourceArray = new Integer[]{-5,4,10,2,1,8,-5,0};
        Integer [] expectArray = new Integer[]{-5,-5,0,1,2,4,8,10};
        QuickSort<Integer> quickSortAlg = new QuickSort<>(sourceArray);
        quickSortAlg.quickSortArray(0, sourceArray.length- 1);
        assertThat(quickSortAlg.getArray()).isEqualTo(expectArray);
    }
    //  Завдання 1 — спадання
    @Test
    public void testQuickSortDescending(){
        Integer[] sourceArray = new Integer[]{1, 5, 3, 7, 2};
        Integer[] expectArray = new Integer[]{7, 5, 3, 2, 1};
        QuickSort<Integer> quickSort = new QuickSort<>(sourceArray);
        quickSort.quickSortArrayDescending(0, sourceArray.length - 1);
        assertThat(quickSort.getArray()).isEqualTo(expectArray);
    }

    //  Завдання 2 — центральний елемент
    @Test
    public void testQuickSortWithMiddlePivot(){
        Integer[] sourceArray = new Integer[]{8, 3, 7, 2, 5};
        Integer[] expectArray = new Integer[]{2, 3, 5, 7, 8};
        QuickSort<Integer> quickSort = new QuickSort<>(sourceArray);
        quickSort.quickSortArrayWithMiddlePivot(0, sourceArray.length - 1);
        assertThat(quickSort.getArray()).isEqualTo(expectArray);
    }

    //  Завдання 3 — випадковий елемент
    @Test
    public void testQuickSortWithRandomPivot(){
        Integer[] sourceArray = new Integer[]{6, 4, 9, 1, 3};
        Integer[] expectArray = new Integer[]{1, 3, 4, 6, 9};
        QuickSort<Integer> quickSort = new QuickSort<>(sourceArray);
        quickSort.quickSortArrayWithRandomPivot(0, sourceArray.length - 1);
        assertThat(quickSort.getArray()).isEqualTo(expectArray);
    }
    @Test
    public void testCompareSortingTimes() {
        Integer[] sourceArray = new Integer[]{10, 3, 7, 5, 1, 9, 2, 8, 4, 6};

        QuickSort<Integer> quickSort = new QuickSort<>(sourceArray);
        long totalTime = quickSort.compareSortingTimes(0, sourceArray.length - 1);

        System.out.println("Загальний час сортування з усіма стратегіями вибору опорного елемента : " + totalTime + " наносекунд");
    }
}
