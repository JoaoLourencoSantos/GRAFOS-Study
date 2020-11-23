package com.company;

import com.company.dao.FileManager;
import com.company.dao.FileManagerMatrix;
import com.company.dao.FileManagerVertex;
import com.company.domain.Edge;
import com.company.domain.Matrix;
import com.company.domain.Vertex;
import com.company.service.AGMService;
import com.company.utils.InfoManager;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileManager fileManagerVertex = new FileManagerVertex();
        FileManager fileManagerMatrix = new FileManagerMatrix();

        List<Vertex> listVertex = fileManagerVertex.read();
        List<List<Matrix>> listMatrix = fileManagerMatrix.read();

        List<List<Edge>> result = InfoManager.buildListEdge(listVertex, listMatrix);

        print(result);

        AGMService agmService = new AGMService();

        //JA TEMOS A LISTA DE ARESTAS QUE REPRESENTA A ARVORE GERADORA MINIMA...
        List<Edge> edges = agmService.generatePrim(result);
    }


    private static void print(List<List<Edge>> result) {

        Integer count = 0;

        for (List<Edge> value : result) {
            System.out.println("Vertice " + count + 1);

            for (Edge edge : value) {
                System.out.println("\tAresta " + value.indexOf(edge) + " = " + edge.toString());
            }

            count++;
        }

    }
}
