package com.seongwon.junit;

import java.io.File;

public class XlsReader {
    File file;

    public XlsReader(File file) {
        if (!file.isFile())
            return;
        this.file = file;
    }

    public XlsReader(String file) {
        this.file = new File(file);
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