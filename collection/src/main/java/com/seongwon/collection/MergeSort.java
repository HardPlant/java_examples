package com.seongwon.collection;

import com.seongwon.collection.Sort;

public class MergeSort implements Sort{
    int[] array;
    public MergeSort(int[] array){
        this.array = array;
    }
    @Override
    public int[] sort() {
        
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
        for(int i=low; low<high; i++)
            if(array[low] > array[high]) array[low] = array[high];
    }
}