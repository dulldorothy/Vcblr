package com.company.service;

import java.util.HashMap;

public interface FileReader {
   HashMap<String, String> readFile();
   void saveIntoFile(String filename);

}
