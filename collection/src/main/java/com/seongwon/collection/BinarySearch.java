package com.seongwon.collection;

import com.seongwon.collection.Search;

public class BinarySearch implements Search{
    int[] array;
    int x;
    
    public BinarySearch(int[] array){
        this.array = array;
    }
    @Override
    public int search() {
        return search_recursive(array, x, array.length/2);
    }
    public int search(int x){
        setX(x);
        return search();
    }
    public int search_recursive(int[] array, int x, int index) {
        if(index < 0 || index > array.length-1) return -1;
        
        if (array[index]< x) return search_recursive(array, x, (index+array.length)/2);
        else if (array[index]> x) return search_recursive(array, x, index/2);
        
        return index;
    }
    public boolean contains_x(int index){
        return true;
    }
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
}