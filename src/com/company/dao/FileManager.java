package com.company.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class FileManager<T> {

    protected int line = 0;

    protected abstract String getFileName();

    protected abstract T buildEntity(String[] resultSplit);

    public List<T> read() {
        try {
            line = 0;

            List<T> vertexList = new ArrayList<>();

            File textFile = new File(getFileName());
            Scanner reader = new Scanner(textFile);

            while (reader.hasNextLine()) {
                String resultLine = reader.nextLine();

                if (resultLine != null) {
                    String[] resultSplit = resultLine.split(getSplitSeparator());

                    vertexList.add(buildEntity(resultSplit));
                }

                line++;
            }

            print(vertexList);

            reader.close();
            return vertexList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    protected String getSplitSeparator() {
        return " ";
    }

    private void print(List<T> list) {
        for (T value : list) {
            System.out.println(value.toString());
        }
    }

    protected Integer convert(String value) {
        return Integer.parseInt(value);
    }
}
