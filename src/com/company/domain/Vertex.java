package com.company.domain;

public class Vertex {

    private int vertexId;
    private int areaId;

    public Vertex(int vertexId, int areaId) {
        this.vertexId = vertexId;
        this.areaId = areaId;
    }

    public int getVertexId() {
        return vertexId;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
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
