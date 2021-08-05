package com.company.service;

import java.io.IOException;
import java.util.HashMap;

public interface FileReader {
   HashMap<String, String> readFile() throws IOException;
   void saveIntoFile(HashMap<String,String> wordlist) throws IOException;


}
