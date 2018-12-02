package com.seongwon.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class MergeSortTest{
    private boolean is_sorted(int[] array){
        for(int idx = 0; idx < array.length-1; idx++){
            if(array[idx]>array[idx+1]) return false;
        }
        return true;
    }
    @Test
    public void recursiveTest(){
        int[] arr = {-1,4,3,2,1};
        MergeSort msort = new MergeSort();
        msort.sort(arr);
        assertTrue(is_sorted(arr));
    }
}