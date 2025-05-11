package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort3 {
    int[] array;

    public CountingSort3(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int[] getArray() {
        return array;
    }
    public void countSort(){
        int max = Arrays.stream(array).max().getAsInt();
        int[] count = new int[max+1];
        for (int i=0; i<array.length;i++){
            count[array[i]]++;
        }
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        int[] sortedArray=new int[array.length];
        for(int i =sortedArray.length-1;i>=0;i--){
            sortedArray[count[array[i]]-1]=array[i];
            count[array[i]]--;
        }
        array=Arrays.copyOf(sortedArray,sortedArray.length);
    }
    public void redixSort(){
        int max=Arrays.stream(array).max().getAsInt();
        for(int exp=1;max/exp>0;exp*=10){
            int[] sortedArray = countSortForRedix(exp);
            array=Arrays.copyOf(sortedArray,sortedArray.length);
        }
    }
    public int [] countSortForRedix(int exp){
        int[] countArray=new int[10];
        for(int i=0;i< array.length;i++){
            countArray[array[i]/exp%10]++;
        }
        for (int i=1;i<countArray.length;i++){
            countArray[i]+=countArray[i-1];
        }
        int[] sortedArray=new int[array.length];
        for (int i=sortedArray.length-1;i>=0;i--){
            sortedArray[countArray[array[i]/exp%10]-1]=array[i];
            countArray[array[i]/exp%10]--;
        }
        return sortedArray;
    }
    public void countSortDescendingWithNegatives() {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        for (int value : array) {
            count[value - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sorted = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sorted[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Реверс для сортування за спаданням
        for (int i = 0; i < sorted.length / 2; i++) {
            int temp = sorted[i];
            sorted[i] = sorted[sorted.length - 1 - i];
            sorted[sorted.length - 1 - i] = temp;
        }

        array = sorted;
    }
    public void radixSortDescendingWithNegatives() {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();

        // Розділяємо на позитивні і негативні
        for (int num : array) {
            if (num < 0) {
                negatives.add(-num); // беремо модуль
            } else {
                positives.add(num);
            }
        }

        // Сортуємо позитивні числа
        int[] posArray = positives.stream().mapToInt(i -> i).toArray();
        radixSortCore(posArray); // за зростанням
        reverse(posArray); // за спаданням

        // Сортуємо негативні числа (з модулем)
        int[] negArray = negatives.stream().mapToInt(i -> i).toArray();
        radixSortCore(negArray); // за зростанням

        // Повертаємо знаки для негативних чисел
        for (int i = 0; i < negArray.length; i++) {
            negArray[i] = -negArray[i]; // повертаємо мінуси
        }

        // Об'єднуємо
        int[] result = new int[array.length];
        int idx = 0;

        // Додаємо позитивні
        for (int num : posArray) result[idx++] = num;
        // Додаємо негативні
        for (int num : negArray) result[idx++] = num;

        array = result;
    }


    private void radixSortCore(int[] arr) {
        int max = getMax(arr);

        // Переходимо по кожному розряду: 1, 10, 100...
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    private void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // цифри від 0 до 9

        // Підрахунок кількості кожної цифри на поточному розряді
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Префіксна сума — для правильної позиції в output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Формуємо вихідний масив (в зворотному порядку для стабільності)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Копіюємо назад в arr
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }


    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}