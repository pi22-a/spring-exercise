package com.springboot.api.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLineContext<T> {

    private Parser<T> parser;

    public ReadLineContext(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readByLine(String filename) throws IOException {
        // 삽
        List<T> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(filename)
        );
        String str;
        while ((str = reader.readLine()) != null) {
            try {
                result.add(parser.parse(str));
            } catch (Exception e) {
                System.out.printf("파싱중 문제가 생겨 이 라인은 path 합니다. 파일 내용: %s \n", str);
            }
        }
        reader.close();
        return result;
    }
}
