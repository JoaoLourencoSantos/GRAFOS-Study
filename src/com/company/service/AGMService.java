package com.company.service;

import com.company.domain.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AGMService {

    List<Edge> result = new ArrayList<>();
    List<List<Edge>> copyFork;

    public List<Edge> generatePrim(List<List<Edge>> fork){
        List<Integer> vertices = new ArrayList<>();
        final List<Edge> listMin = new ArrayList<>();
        vertices.add(0);

        //para encontrar a árvore geradora minima precisamos de um loop
        //de nVertices - 1, para encontrar todas as arestas
        for(int i = 0; i < fork.size() - 1; i++){

            //dentro dos vertices que ja foram passados, pegar as menores arestas
            vertices.forEach((vertex) -> {
                List<Edge> list =  fork.get(vertex);
                if(list != null){
                    Edge min = list.stream()
                            .filter((e) -> !vertices.contains(e.getSecondVertex().getVertexId() - 1))
                            .sorted(Comparator.comparingInt(Edge::getDisparity))
                            .collect(Collectors.toList()).get(0);
                    listMin.add(min);
                }
            });

            //pegar a menor das menores arestas e incluir no resultado final
            Edge min = listMin.stream()
                    .sorted(Comparator.comparingInt(Edge::getDisparity))
                    .collect(Collectors.toList()).get(0);
            fork.get(min.getFirstVertex().getVertexId() - 1).remove(min);
            result.add(min);
            vertices.add(min.getSecondVertex().getVertexId() - 1 );

            //limpar lista de menores
            listMin.clear();
        }

        System.out.println("--------------------------------------------------------------------------------");
        printFork(result);
        System.out.println("--------------------------------------------------------------------------------");

        return result;

    }


    private void printFork(List<Edge> result){
        result.forEach( (edge) ->{
            System.out.println("Aresta " + edge.getFirstVertex().getVertexId()
                    + " <-------"
                    + edge.getDisparity()
                    + "-------> "
                    + edge.getSecondVertex().getVertexId());
        });
    }
}
