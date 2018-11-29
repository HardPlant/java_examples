package com.seongwon.junit;

import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {
    File file;
    XSSFWorkbook workbook;

    public XlsReader(File file) {
        if (!file.isFile())
            return;
        this.file = file;
    }

    public XlsReader(String file) {
        this.file = new File(file);
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