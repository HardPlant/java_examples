package com.seongwon.collection;

import com.seongwon.collection.Sort;

public class MergeSort implements Sort{
    int[] array;
    public MergeSort(){
    
    }
    @Override
    public int[] sort(int[] array) {
        setArray(array);
        mergeSort_first(this.array);
        return this.array;
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
            final int high_half = n - low_half;
            int[] low_array = make_array(array, 0, low_half);
            int[] high_array = make_array(array, low_half+1, high_half);
            mergeSort_first(low_array);
            mergeSort_first(high_array);
            merge(low_half, high_half, low_array, high_array, array);
        }
    }
    private void merge(int low_half, int high_half
    , int[] low_array, int[] high_array, int[] merging_array){
        int i, j, k;
        i=0;
        j=0;
        k=0;
        while(i<=low_half && j<=high_half){
            if(low_array[i] < high_array[j]){
                merging_array[k] = low_array[i];
                i++;
            } else {
                merging_array[k] = high_array[j];
                j++;
            }
            k++;
        }
        if(j<=high_half){
            for(;i < low_half+high_half;i++){
                merging_array[k] = low_array[i];
            }
        } else{
            for(;j < low_half+high_half;j++){
                merging_array[k] = high_array[j];
            }
        }
    }
    /**
     * @param array the array to set
     */
    public void setArray(int[] array) {
        this.array = array;
    }
}