package com.company.service.impl;

import com.company.entity.PairSet;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReaderImpl implements com.company.service.FileReader {

    private final String fileName;
    private final FileReader fileReader;

    public FileReaderImpl(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.fileReader = new FileReader(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public HashMap<String, String> readFile() throws IOException {
        HashMap<String, String> result = new HashMap<>();

        try(BufferedReader br = new BufferedReader(fileReader))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                PairSet words = PairSet.toPairSet(line);
                result.put(words.getEnWord(),words.getRuWord());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void saveIntoFile(HashMap<String,String> wordlist) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        for(Map.Entry<String,String> wordPair : wordlist.entrySet())
        {
            fw.write(wordPair.getKey()+";"+wordPair.getValue() + "\n");
        }
        fw.flush();
        fw.close();
    }
}
