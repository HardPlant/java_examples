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
    /**
     * @param array the array to set
     */
    public void setArray(int[] array) {
        this.array = array;
    }
}