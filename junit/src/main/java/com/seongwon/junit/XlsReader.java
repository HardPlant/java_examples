package com.seongwon.junit;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {
    File file;
    FileInputStream fis;
    XSSFWorkbook workbook;

    public XlsReader(File file) throws Throwable{
        if (!file.isFile())
            return;
        this.file = file;
        this.fis = new FileInputStream(this.file);
    }

    public XlsReader file(File file){
        this.file = file;
        return this;
    }
    public XlsReader workBook(){
        return this;
    }
    public String read() {
        return "it reads";
    }
    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }
}