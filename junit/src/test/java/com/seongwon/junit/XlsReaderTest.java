package com.seongwon.junit;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class XlsReaderTest{
    @Test
    public void setFileTest() throws Throwable{
        XlsReader reader = new XlsReader(new File("src/resources/data.xlsx"));
        assertTrue(reader.getFile() != null);
    }
}