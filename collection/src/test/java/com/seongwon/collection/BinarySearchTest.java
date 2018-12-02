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
        int[] array = {Integer.MIN_VALUE, -1,0,1,4,7,9,13,26,42,   Integer.MAX_VALUE};
        BinarySearch search = new BinarySearch(array);
        assertEquals(search.search(Integer.MIN_VALUE), 0);
        assertEquals(search.search(-1), 1);
        assertEquals(search.search(0), 2);
        assertEquals(search.search(1), 3);
        assertEquals(search.search(4), 4);
        assertEquals(search.search(7), 5);
        assertEquals(search.search(9), 6);
        assertEquals(search.search(13), 7);
        assertEquals(search.search(26), 8);
        assertEquals(search.search(42), 9);
        assertEquals(search.search(Integer.MAX_VALUE), 10);
    }
}