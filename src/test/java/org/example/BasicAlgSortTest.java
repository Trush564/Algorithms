package org.example;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class BasicAlgSortTest {
    @Test
    public void testBubbleSortWhenArraysWithIntegerTypesAndRAngeEqualsLength() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1};
        Integer[] destArray = new Integer[]{1, 2, 4, 5, 10};
        BasicAlgSort<Integer> integerBasicAlgSort = new BasicAlgSort<>(sourceArray);
        integerBasicAlgSort.bubbleSortAsc();
        assertThat(integerBasicAlgSort.getArray()).isEqualTo(destArray);
    }

    @Test
    public void testSelectionSortWhenArraysWithIntegerTypesAndRangeEqualsLength() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1};
        Integer[] destArray = new Integer[]{1, 2, 4, 5, 10};
        BasicAlgSort<Integer> integerBasicAlgSort = new BasicAlgSort<>(sourceArray);
        integerBasicAlgSort.selectSortAsc();
        assertThat(integerBasicAlgSort.getArray()).isEqualTo(destArray);
    }

    @Test
    public void testInsertionSortWhenArraysWithIntegerTypesAndRangeEqualsLength() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1, 8, -5, 0};
        Integer[] destArray = new Integer[]{-5, 0, 1, 2, 4, 5, 8, 10};
        BasicAlgSort<Integer> integerBasicAlgSort = new BasicAlgSort<>(sourceArray);
        integerBasicAlgSort.insertionSortWithLinearSearchAsc();
        assertThat(integerBasicAlgSort.getArray()).isEqualTo(destArray);
    }

    @Test
    public void testInsertionSortWithBinarySearchWhenArraysWithIntegerTypesAndRangeEqualsLength() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1, 8, -5, 0};
        Integer[] destArray = new Integer[]{-5, 0, 1, 2, 4, 5, 8, 10};
        BasicAlgSort<Integer> integerBasicAlgSort = new BasicAlgSort<>(sourceArray);
        integerBasicAlgSort.insertionSortWithBinarySearchAsc();
        assertThat(integerBasicAlgSort.getArray()).isEqualTo(destArray);
    }
    @Test
    public void testBubbleSort(){
        Integer[] sourceArray={5,2,9,1,6,3};
        Integer[]expectedArray={5,9,6,3,2,1};
        BasicAlgSort<Integer>sorter=new BasicAlgSort<>(sourceArray);
        sorter.bubbleSort(1,4);
        assertThat(sorter.getArray()).isEqualTo(expectedArray);
    }
    @Test
    public void testSort(){
        int size=10000;
        Integer[]array=new  Random().ints(size, -100, 101).boxed().toArray(Integer[]::new);
        BasicAlgSort<Integer> sorter1 = new BasicAlgSort<>(array);
        BasicAlgSort<Integer> sorter2 = new BasicAlgSort<>(array);

        long timeLinear = BasicAlgSort.measureSort(() -> sorter1.bubbleSortAsc());
        long timeBinary = BasicAlgSort.measureSort(() -> sorter2.insertionSortWithBinarySearchAsc());


        System.out.println("Linear Sort Time: " + timeLinear / 1_000_000.0 + " ms");
        System.out.println("Binary Sort Time: " + timeBinary / 1_000_000.0 + " ms");
        assertThat(timeBinary).isGreaterThan(0);
    }

    public static Integer[] getRandomInteger(int n) {
        Integer[] sourceArray = new Integer[n];
        Random random=new Random();
        for (int i = 0; i < n; i++) {
            sourceArray[i] = new Random().nextInt(200) - 100;
        }
        return sourceArray;
    }
    @Test
    public void testBubbleSortDesc() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1};
        Integer[] expectedArray = new Integer[]{10, 5, 4, 2, 1};
        BasicAlgSort<Integer> integerBasicAlgSort = new BasicAlgSort<>(sourceArray);
        integerBasicAlgSort.bubbleSortDesc(0, sourceArray.length - 1);
        assertThat(integerBasicAlgSort.getArray()).isEqualTo(expectedArray);
    }

    @Test
    public void testSelectSortDesc() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1};
        Integer[] expectedArray = new Integer[]{10, 5, 4, 2, 1};
        BasicAlgSort<Integer> integerBasicAlgSort = new BasicAlgSort<>(sourceArray);
        integerBasicAlgSort.selectSortDesc(0, sourceArray.length - 1);
        assertThat(integerBasicAlgSort.getArray()).isEqualTo(expectedArray);
    }

    @Test
    public void testInsertionSortDesc() {
        Integer[] sourceArray = new Integer[]{5, 4, 10, 2, 1, 8, -5, 0};
        Integer[] expectedArray = new Integer[]{10, 8, 5, 4, 2, 1, 0, -5};
        BasicAlgSort<Integer> integerBasicAlgSort = new BasicAlgSort<>(sourceArray);
        integerBasicAlgSort.insertionSortDesc(0, sourceArray.length - 1);
        assertThat(integerBasicAlgSort.getArray()).isEqualTo(expectedArray);
    }

    @Test
    public void testRandomDescSort() {
        int size = 10000;
        Integer[] array = new Random().ints(size, -100, 101).boxed().toArray(Integer[]::new);
        BasicAlgSort<Integer> sorter = new BasicAlgSort<>(array);

        long timeBubble = BasicAlgSort.measureSort(() -> sorter.bubbleSortDesc(0, array.length - 1));
        System.out.println("Bubble Sort Time (Descending): " + timeBubble / 1_000_000.0 + " ms");
    }
}