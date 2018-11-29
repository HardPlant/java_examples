package com.seongwon.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class XlsReaderTest{
    @Test
    public void setFileTest() throws Throwable{
        URL url = this.getClass().getClassLoader().getResource("data.xlsx");

        XlsReader reader = 
        new XlsReader()
            .file(new File(url.toURI()));
        assertTrue(reader.getFile() != null);
        //(1,1) : 1
        //(1,2) : 2
        //(1,3) : 3
        //(1,4) : 4
        //(1,5) : 5
        String result = reader.read(1,1);
        assertEquals(result,"1");
    }
}