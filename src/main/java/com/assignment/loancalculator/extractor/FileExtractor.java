package com.assignment.loancalculator.extractor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExtractor implements  Extractor {
    @Override
    public String extract(String target) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(target));
            return new String(encoded, Charset.defaultCharset());

        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }
}