package com.company.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class FileReaderImpl implements com.company.service.FileReader {

    private final String fileName;
    private final FileReader fileReader;

    public FileReaderImpl(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.fileReader = new FileReader(fileName);
    }

    @Override
    public HashMap<String, String> readFile() {
        return null;
    }

    @Override
    public void saveIntoFile(String filename) {

    }
}
