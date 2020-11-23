package com.company.service;

import com.company.domain.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AGMService {

    List<Edge> result = new ArrayList<>();

    public List<Edge> generatePrim(List<List<Edge>> fork){
        List<Integer> verticesExplored = new ArrayList<>();
        final List<Edge> listMin = new ArrayList<>();

        //ja adiciona o primeiro vertice aos vertices explorados
        verticesExplored.add(0);

        //para encontrar a árvore geradora minima precisamos de um loop
        //de nVertices - 1, para encontrar todas as arestas
        for(int i = 0; i < fork.size() - 1; i++){

            //dentro dos vertices que ja foram passados, pega as menores arestas
            verticesExplored.forEach((vertex) -> {

                //pega a lista de arestas do vertice desejado
                List<Edge> list = fork.get(vertex);

                if(list != null){

                    list = list.stream()
                            // o filter é necessário para nao ser escolhida uma aresta com um vertice que ja estava na lista,
                            // dessa forma faria um ciclo
                            .filter((e) -> !verticesExplored.contains(e.getSecondVertex().getVertexId() - 1))
                            .sorted(Comparator.comparingInt(Edge::getDisparity))
                            .collect(Collectors.toList());

                    if(!list.isEmpty()) {
                        Edge min = list.get(0);
                        listMin.add(min);
                    }
                }
            });

            //pega a menor das menores arestas
            Edge min = listMin.stream()
                    .sorted(Comparator.comparingInt(Edge::getDisparity))
                    .collect(Collectors.toList()).get(0);

            //incluir essa menor aresta no resultado final (ja faz parte da AGM)
            result.add(min);

            //necessário remover aresta que ja foi incluida na AGM para nao ser usada novamente
            fork.get(min.getFirstVertex().getVertexId() - 1).remove(min);

            //adicionar o vertice da aresta menor encontrada na lista de vertice que serao buscados na proxima iteracao
            verticesExplored.add(min.getSecondVertex().getVertexId() - 1 );

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
