package com.seongwon.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class MergeSortTest{
    private boolean is_sorted(int[] array){
        System.out.println("Checking...");
        for(int idx = 0; idx < array.length-1; idx++){
            System.out.print(array[idx] + " ");
            if(array[idx]>array[idx+1]){
                System.out.println(array[idx]+1 + "Not matches");
                return false;
            }
        }
        System.out.println();
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