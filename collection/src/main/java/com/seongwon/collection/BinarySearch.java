package com.seongwon.collection;

import com.seongwon.collection.Search;

public class BinarySearch implements Search{
    int[] array;
    
    public BinarySearch(int[] array){
        this.array = array;
    }
    @Override
    public int search_recursive(int[] array, int x, int index) {
        if(index < 0 || index > array.length) return -1;
        if(array[index] == x) return index;
        else if (array[index]< x) return search_recursive(array, x, (index+array.length)/2);
        else if (array[index]> x) return search_recursive(array, x, index/2);
    }
    public boolean contains_x(int index){

    }
}