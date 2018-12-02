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
        return search_recursive(0, array.length-1);
    }
    public int search(int x){
        setX(x);
        return search();
    }
    public int search_recursive(int low, int high) {
        int mid;
        if(low>high) return -1;
        else {
            mid = (low+high)/2;
            if(array[mid] == x) return mid;
            else if(x<array[mid]) return search_recursive(low, mid-1);
            else
                return search_recursive(mid+1, high);
        }        
    }
    public int search_iterative(int x){
        setX(x);
        assert(array != null);
        int low = 0;
        int high = array.length -1;
        int mid = -1;
        for(;low<=high;){
            mid = (low + high) / 2;
            if(array[mid] == x) break;
            if(array[mid] > x) high = mid - 1;
            else low = mid+1;
        }
        return mid;
        
    }
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
}