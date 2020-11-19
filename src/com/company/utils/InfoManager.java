package com.company.utils;

import com.company.domain.Edge;
import com.company.domain.Matrix;
import com.company.domain.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InfoManager {

    public static List<List<Edge>> buildListEdge(List<Vertex> listVertex, List<List<Matrix>> listMatrix) {
        List<List<Edge>> resultList = new ArrayList<>();


        for (Vertex vertex1 : listVertex) {
            List<Edge> singleListResult = new ArrayList<>();

            for (Vertex vertex2 : listVertex) {
                Integer area1 = vertex1.getAreaId(), area2 = vertex2.getAreaId();

                if (vertex1.equals(vertex2)) {
                    continue;
                }

                Edge edge = new Edge(vertex1, vertex2, findDisparityByVertex(area1, area2, listMatrix));

                if (singleListResult.contains(edge)) {
                    continue;
                }

                singleListResult.add(edge);
            }

            singleListResult = singleListResult.stream().distinct().collect(Collectors.toList());

            resultList.add(singleListResult);
        }

        return resultList;
    }

    private static Integer findDisparityByVertex(Integer area1, Integer area2, List<List<Matrix>> listMatrix) {

        if (listMatrix.isEmpty()) {

            System.out.println("Algum erro aconteceu, não foi possivel montar a matriz ");

            return 0;
        }

        List<Matrix> referenceList = listMatrix.get(area1 - 1);

        Matrix result = referenceList.stream()
                .filter(val -> val.getFirstAreaId().equals(area1) && val.getSecondAreaId().equals(area2))
                .findAny()
                .orElse(null);

        if (result == null) {
            return 0;
        }

        return result.getDisparity();
    }
}
