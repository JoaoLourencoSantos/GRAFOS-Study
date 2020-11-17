package com.company.dao;

import com.company.domain.Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileManagerMatrix extends FileManager<List<Matrix>> {
    @Override
    protected String getFileName() {
        return "src/com/company/data/disparity.txt";
    }

    @Override
    protected String getSplitSeparator() {
        return "\t";
    }

    // O arquivo é populado pelas disparidades entre as áreas
    @Override
    protected List<Matrix> buildEntity(String[] resultSplit) {

        if (resultSplit == null && resultSplit.length == 0) {
            return new ArrayList<>();
        }

        List<Matrix> values = IntStream.range(0, resultSplit.length)
                .mapToObj(index -> new Matrix(line, index, convert(resultSplit[index])))
                .collect(Collectors.toList());

        return values;

    }

}
