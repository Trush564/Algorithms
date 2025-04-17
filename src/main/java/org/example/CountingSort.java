package org.example;

import java.util.Arrays;
public class CountingSort {
    static void sort(int arr[]) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[11];
        for (int i = 0; i < count.length; ++i)
            count[i] = 0;
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];
        System.out.println("Значення повторюавності елементів у масиві: ");
        for (int i = 0; i < n; ++i)
            System.out.print(count[i] + " ");
        System.out.println();

        for (int i = 1; i <= 10; ++i)
            count[i] += count[i - 1];

        System.out.println("Значення суми count[i] та count[i-1]: ");
        for (int i = 0; i < n; ++i)
            System.out.print(count[i] + " ");
        System.out.println();

        for (int i = 0; i < n; ++i) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }

    static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortByDigit(arr, exp);
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max)
                max = i;
        }
        return max;
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
    public static void main(String args[]) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 11));
        }
        System.out.println("Вхідний масив: ");
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println("Вихідний масив: ");
        System.out.println(Arrays.toString(arr));

        int[] arrRadix = new int[10];
        for (int i = 0; i < arrRadix.length; i++) {
            arrRadix[i] = ((int) (Math.random() * 889));
        }

        System.out.println("\nВхідний масив (для RadixSort): ");
        System.out.println(Arrays.toString(arrRadix));
        radixSort(arrRadix);
        System.out.println("Вихідний масив після RadixSort: ");
        System.out.println(Arrays.toString(arrRadix));
    }
}

