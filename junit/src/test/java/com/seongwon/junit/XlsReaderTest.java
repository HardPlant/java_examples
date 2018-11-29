package com.seongwon.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XlsReaderTest{
    @Test
    public void setFileTest(){
        XlsReader reader = new XlsReader("src/resources/data.xlsx");
        assertTrue(reader.getFile() != null);
    }
}