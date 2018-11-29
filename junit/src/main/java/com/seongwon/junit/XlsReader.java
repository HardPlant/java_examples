package com.seongwon.junit;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {
    File file;
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    public XlsReader(){

    }
    public XlsReader(File file) throws Throwable{
        if (!file.isFile())
            return;
        this.file(file);
    }

    public XlsReader file(File file) throws Throwable{
        this.file = file;
        this.fis = new FileInputStream(this.file);
        this.workbook = new XSSFWorkbook(this.fis);
        return this;
    }
    public XlsReader readSheet(int sheetNum) {
        this.sheet = this.workbook.getSheetAt(sheetNum);
        return this;
    }
    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }
    /**
     * @return the sheet
     */
    public XSSFSheet getSheet() {
        return sheet;
    }
}