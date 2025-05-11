package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CountingSort3Test {
    @Test
    public void testCountingSort3() {
        int[] sourceArray = new int[]{5, 4, 10, 2, 1, 8, 5, 0};
        int[] expectArray = new int[]{0, 1, 2, 4, 5, 5, 8, 10};
        CountingSort3 countingSort3 = new CountingSort3(sourceArray);
        countingSort3.countSort();
        assertThat(countingSort3.getArray()).isEqualTo(expectArray);
    }
    @Test
    public void testRedixSort() {
        int[] sourceArray = new int[]{5,410,10,2,1,850,5,0};
        int[] expectArray = new int[]{0,1,2,5,5,10,410,850};
        CountingSort3 countingSort3 = new CountingSort3(sourceArray);
        countingSort3.redixSort();
        assertThat(countingSort3.getArray()).isEqualTo(expectArray);
    }
    @Test
    public void testCountSortDescendingWithNegatives() {
        int[] input = {3,5,-10,-3,-5,-3,6,-2};
        int[] expected = {6,5,3,-2,-3,-3,-5,-10};
        CountingSort3 sorter = new CountingSort3(input);
        sorter.countSortDescendingWithNegatives();
        assertThat(sorter.getArray()).isEqualTo(expected);
    }

    @Test
    public void testRadixSortDescendingWithNegatives() {
        int[] input = {-122, -300, -5, 5, 2, -855, 0, -99};
        int[] expected = {5, 2, 0, -5, -99, -122, -300, -855};
        CountingSort3 sorter = new CountingSort3(input);
        sorter.radixSortDescendingWithNegatives();
        assertThat(sorter.getArray()).isEqualTo(expected);
    }
}