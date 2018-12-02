package com.seongwon.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import com.seongwon.collection.BinarySearch;

import org.junit.Test;
public class BinarySearchTest{
    @Test
    public void recursiveTest(){
        int[] array = {1,9,4,7,13,26,42, -1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        BinarySearch search = new BinarySearch(array);
        assertEquals(search.search(1), 0);
        assertEquals(search.search(9), 1);
        assertEquals(search.search(4), 2);
        assertEquals(search.search(7), 3);
        assertEquals(search.search(13), 4);
        assertEquals(search.search(26), 5);
        assertEquals(search.search(42), 6);
        assertEquals(search.search(-1), 7);
        assertEquals(search.search(0), 8);
        assertEquals(search.search(Integer.MAX_VALUE), 9);
        assertEquals(search.search(Integer.MIN_VALUE), 10);
    }
}