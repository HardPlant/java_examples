package com.seongwon.collection;

import com.seongwon.collection.Sort;

public class MergeSort implements Sort{
    int[] array;
    public MergeSort(){
    
    }
    @Override
    public int[] sort(int[] array) {
        setArray(array);
        mergeSort_first(this.array.length, this.array);
        return this.array;
    }
    public int[] make_array(int[] array, int low, int high){
        int[] result = new int[high-low];
        System.out.println("Array Made:"); 
        for(int i=0; i<result.length; i++){
            result[i] = array[low+i];
            System.out.print(result[i] + " "); 
        }
        System.out.println();
        return result;
    }
    private void mergeSort_first(int n, int[] array){
        if(n > 1){
            final int low_half = n/2;
            final int high_half = n - low_half;
            int[] low_array = make_array(array, 0, low_half);
            int[] high_array = make_array(array, low_half, n);
            mergeSort_first(low_half, low_array);
            mergeSort_first(high_half, high_array);
            merge(low_half, high_half, low_array, high_array, array);
        }
    }
    private void merge(int low_half, int high_half
    , int[] low_array, int[] high_array, int[] merging_array){
        int i, j, k;
        i=0;
        j=0;
        k=0;
        while(i<low_half && j<high_half){
            if(low_array[i] < high_array[j]){
                merging_array[k] = low_array[i];
                System.out.println("Merging "+ merging_array[k]);
                i++;
            } else {
                merging_array[k] = high_array[j];
                System.out.println("Merging "+ merging_array[k]);
                j++;
            }
            k++;
        }
        if(j<high_half){
            for(;i < low_half;i++){
                merging_array[k] = low_array[i];
                System.out.println("Merging "+ merging_array[k]);
            }
        } else{
            for(;j < high_half;j++){
                merging_array[k] = high_array[j];
                System.out.println("Merging "+ merging_array[k]);
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