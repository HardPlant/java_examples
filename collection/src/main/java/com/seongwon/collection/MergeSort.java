package com.seongwon.collection;

import com.seongwon.collection.Sort;

public class MergeSort implements Sort{
    int[] array;
    public MergeSort(){
    
    }
    @Override
    public int[] sort(int[] array) {
        setArray(array);
        divide(0, array.length-1);
        return this.array;
    }
    private void divide(int low, int high){
        if(low>high) return;
        int mid = (low + high) / 2;
        divide(low, mid);
        divide(mid+1, high);
        conquer(low, high);
    }
    private void conquer(int low, int high){
        for(int i=low; low<high; i++){
            if(array[low] > array[high]){
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
    }
    public int[] make_array(int[] array, int low, int high){
        int[] result = new int[high-low + 1];
        for(int i=0; i<=high-low+1; i++){
            result[i] = array[low+i];
        }
        return result;
    }
    private void mergeSort_first(int[] array){
        int n = array.length - 1;
        if(n > 1){
            final int low_half = n/2;
            final int higher_half = n - low_half;
            int[] low_array = make_array(array, 0, low_half);
            int[] high_array = make_array(array, low_half+1, high_half);
            mergeSort_first(low_array);
            mergeSort_first(high_array);
            merge(low_half, higher_half, low_array, high_array, array);
        }
    }
    private void merge(int low_half, int higher_half
    , int[] low_array, int[] high_array, int[] merging_array){
        int i, j, k;
        i=0;
        j=0;
        k=0;
        while(i<=low_half && j<=higher_half){
            if(low_array[i] < high_array[j]){
                merging_array[k] = low_array[i];
                i++;
            } else {
                merging_array[k] = high_array[j];
                j++;
            }
            k++;
        }
    }
    /**
     * @param array the array to set
     */
    public void setArray(int[] array) {
        this.array = array;
    }
}