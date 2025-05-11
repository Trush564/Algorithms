package org.example;
import java.util.Arrays;
import java.util.Random;

public class BasicAlgSort<T extends Comparable<? super T>> {
    private int left;
    private int right;
    private T[] array;
    public BasicAlgSort(T[]array){this.array=Arrays.copyOf(array,array.length);}
    public T[] getArray(){
        return array;
    }

    public BasicAlgSort(int left, int right, T[] array) {
        this.left = left;
        this.right = right;
        this.array = Arrays.copyOfRange(array,left,right);
    }
    public void bubbleSortAsc(){
        boolean flagForInteration=true;
        while(flagForInteration){
            flagForInteration=false;
            for(int i =1; i< array.length;i++){
                if(array[i].compareTo(array[i-1])<0){
                    swap(i,i-1);
                    if(!flagForInteration){
                        flagForInteration=true;
                    }
                }
            }
        }
    }
    private void swap(int leftIndex,int righIndex){
        T temp = array[leftIndex];
        array[leftIndex]=array[righIndex];
        array[righIndex]=temp;
    }
    public void selectSortAsc(){
        for(int i=0; i< array.length;i++){
            int minIndex=i;
            T min=array[i];
            for(int j=i+1;j< array.length;j++){
                if(array[j].compareTo(min)<0){
                    min=array[j];
                    minIndex=j;
                }
            }
            if(i!=minIndex)swap(i,minIndex);
        }
    }
    public void insertionSortWithLinearSearchAsc(){
        for(int i=1;i< array.length;i++){
            T key = array[i];
            int j=i;
            for(;j>0;j--){
                if(key.compareTo(array [j-1] )< 0){
                    array[j]=array[j-1];
                }else{
                    break;
                }
            }
            array[j]=key;
        }
    }
    public void insertionSortWithBinarySearchAsc() {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int leftIndex = 0;
            int rightIndex = i - 1;
            if (key.compareTo(array[i - 1]) < 0) {
                while (leftIndex < rightIndex) {
                    int serIndex = (rightIndex + leftIndex) / 2;
                    if (key.compareTo(array[serIndex]) < 0) {
                        rightIndex = serIndex;
                    } else {
                        leftIndex = serIndex + 1;
                    }
                }
                for (int j = i; j > leftIndex; j--) {
                    array[j] = array[j - 1];
                }
                array[leftIndex] = key;
            }
        }
    }
    public void bubbleSort(int leftIndex,int rightIndex){
        boolean swapped;
        do{
            swapped=false;
            for (int i=leftIndex;i<=rightIndex;i++){
                if(array[i].compareTo(array[i+1])<0){
                    swap(i,i+1);
                    swapped=true;
                }
            }
        }while (swapped);
    }
    public void selectSort(int leftIndex, int rightIndex){
        for (int i=leftIndex;i<rightIndex;i++){
            int maxIndex=i;
            for(int j=i+1;j<=rightIndex;j++){
                if(array[j].compareTo(array[maxIndex])>0){
                    maxIndex=j;
                }
            }
            if (i!=maxIndex)swap(i,maxIndex);
        }
    }
    public void insertionSort(int leftIndex,int rightIndex){
        for (int i=leftIndex+1;i<=rightIndex;i++){
            T key=array[i];
            int j =i-1;
            while (j>=leftIndex&&array[j].compareTo(key)<0){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=key;
        }
    }
    public static long measureSort(Runnable sortMethod){
        long startTime=System.nanoTime();
        sortMethod.run();
        return System.nanoTime()-startTime;
    }
    public static Integer[] getRandomInteger(int n) {
        Integer[] sourceArray = new Integer[n];
        Random random=new Random();
        for (int i = 0; i < n; i++) {
            sourceArray[i] = new Random().nextInt(200) - 100;
        }
        return sourceArray;
    }
    public static void main(String[]args){
        int[]sizes={1000,10000,50000,100000};
        for (int size:sizes){
            Integer[] array1 = BasicAlgSort.getRandomInteger(size);
            Integer[] array2 = Arrays.copyOf(array1, array1.length);
            BasicAlgSort<Integer> sorter1=new BasicAlgSort<>(array1);
            BasicAlgSort<Integer> sorter2=new BasicAlgSort<>(array2);
            long timeLinear =measureSort(sorter1::insertionSortWithLinearSearchAsc);
            long timeBinary=measureSort(sorter2::insertionSortWithBinarySearchAsc);
            System.out.println("Size:"+size+", Linear:"+timeLinear/1000000.0+"ms, Binary:"+timeBinary/1000000.0+"ms");
        }
    }
    public void bubbleSortDesc(int leftIndex, int rightIndex) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) < 0) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public void selectSortDesc(int leftIndex, int rightIndex) {
        for (int i = leftIndex; i < rightIndex; i++) {
            int maxIndex = i;
            for (int j = i + 1; j <= rightIndex; j++) {
                if (array[j].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                swap(i, maxIndex);
            }
        }
    }

    public void insertionSortDesc(int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= leftIndex && array[j].compareTo(key) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
