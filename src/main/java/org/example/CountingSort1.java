package org.example;
import java.util.Arrays;
public class CountingSort1 {
    public static void sort(int[] arr) {
        int N = arr.length;
        if (N == 0)
            return;
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++){
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
        if (range > 10) {
            System.out.println("\nError : Range too large for sort");
            return;
        }
        int[] count = new int[range];
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 11));
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}