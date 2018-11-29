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
        reader.readSheet(0);
    }
}