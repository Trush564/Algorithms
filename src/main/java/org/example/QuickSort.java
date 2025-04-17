package org.example;
import java.util.Arrays;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> {
    T[] array;
    private final Random random;
    public QuickSort(T[] array){
        this.array = Arrays.copyOf(array, array.length);
        this.random=new Random();
    }

    public T[] getArray() {
        return array;
    }
    public void quickSortArray(int first, int last){
        if (first < last){
            int pivotElementIndex = partition(first, last);
            quickSortArray(first, pivotElementIndex - 1);
            quickSortArray(pivotElementIndex + 1, last);
        }
    }

    private int partition(int first, int last) {
        T pivotElement = array[last];
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (array[j].compareTo(pivotElement) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, last);
        return i + 1;
    }

    private void swap(int i , int j){
        T firstElement = array[i];
        array[i]=array[j];
        array[j]= firstElement;
    }
    //  Завдання 1 — Сортування за спаданням (опорний — останній)
    public void quickSortArrayDescending(int first, int last){
        if (first < last){
            int pivotElementIndex = partitionDescending(first, last);
            quickSortArrayDescending(first, pivotElementIndex - 1);
            quickSortArrayDescending(pivotElementIndex + 1, last);
        }
    }

    //  Завдання 2 — Сортування за зростанням (опорний — центральний)
    public void quickSortArrayWithMiddlePivot(int first, int last){
        if (first < last){
            int pivotIndex = first + (last - first) / 2;
            swap(pivotIndex, last);
            int pivotElementIndex = partition(first, last);
            quickSortArrayWithMiddlePivot(first, pivotElementIndex - 1);
            quickSortArrayWithMiddlePivot(pivotElementIndex + 1, last);
        }
    }

    //  Завдання 3 — Сортування за зростанням (опорний — випадковий)
    public void quickSortArrayWithRandomPivot(int first, int last){
        if (first < last){
            int pivotIndex = random.nextInt(last - first + 1) + first;
            swap(pivotIndex, last);
            int pivotElementIndex = partition(first, last);
            quickSortArrayWithRandomPivot(first, pivotElementIndex - 1);
            quickSortArrayWithRandomPivot(pivotElementIndex + 1, last);
        }
    }
    private int partitionDescending(int first, int last) {
        T pivotElement = array[last];
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (array[j].compareTo(pivotElement) >= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, last);
        return i + 1;
    }
    public long compareSortingTimes(int first, int last) {
        long startTime, endTime;

        // Час для сортування з останнім елементом як опорним
        startTime = System.nanoTime();
        quickSortArray(first, last);
        endTime = System.nanoTime();
        long timeLast = endTime - startTime;

        // Час для сортування з центральним елементом як опорним
        startTime = System.nanoTime();
        quickSortArrayWithMiddlePivot(first, last);
        endTime = System.nanoTime();
        long timeMiddle = endTime - startTime;

        // Час для сортування з випадковим елементом як опорним
        startTime = System.nanoTime();
        quickSortArrayWithRandomPivot(first, last);
        endTime = System.nanoTime();
        long timeRandom = endTime - startTime;

        // Виведення результатів
        System.out.println("Час сортування з останнім елементом як опорним: " + timeLast + " наносекунд");
        System.out.println("Час сортування з центральним елементом як опорним: " + timeMiddle + " наносекунд");
        System.out.println("Час сортування з випадковим елементом як опорним: " + timeRandom + " наносекунд");

        // Повертаємо загальний час для порівняння
        return timeLast + timeMiddle + timeRandom;
    }



}
