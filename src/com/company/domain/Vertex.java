package com.company.domain;

public class Vertex {

    private int vertexId;
    private int areaId;
    private int disparity;
    private int referenceVertex;

    public Vertex(int vertexId, int areaId, int disparity, int referenceVertex) {
        this.vertexId = vertexId;
        this.areaId = areaId;
        this.disparity = disparity;
        this.referenceVertex = referenceVertex;
    }

    public Vertex(int vertexId, int areaId) {
        this.vertexId = vertexId;
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "vertexId=" + vertexId +
                ", areaId=" + areaId +
                '}';
    }
}
