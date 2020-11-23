package com.company.dao;

import com.company.domain.Vertex;

public class FileManagerVertex extends FileManager<Vertex> {

    @Override
    protected String getFileName() {
        return "src/com/company/data/CA_CAP_1.txt";
    }

    // O arquivo é populado por ID_ALUNO espaço ID_AREA
    @Override
    protected Vertex buildEntity(String[] resultSplit) {
        return new Vertex(convert(resultSplit[0]), convert(resultSplit[1]));
    }
}
