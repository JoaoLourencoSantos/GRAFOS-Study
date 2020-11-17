package com.company;

import com.company.dao.FileManager;
import com.company.dao.FileManagerMatrix;
import com.company.dao.FileManagerVertex;
import com.company.domain.Matrix;
import com.company.domain.Vertex;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileManager fileManagerVertex = new FileManagerVertex();
        FileManager fileManagerMatrix = new FileManagerMatrix();

        List<Vertex> listVertex = fileManagerVertex.read();
        List<Matrix> listMatrix = fileManagerMatrix.read();
    }
}
