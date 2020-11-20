package com.company.domain;

public class Edge {

    private Vertex firstVertex;
    private Vertex secondVertex;

    private int disparity;

    public Edge(Vertex firstVertex, Vertex secondVertex, int disparity) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.disparity = disparity;
    }

    @Override
    public String toString() {
        return "Edge{" +
                " firstVertex=" + firstVertex +
                ", secondVertex=" + secondVertex +
                ", disparity=" + disparity +
                '}';
    }

    public Vertex getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(Vertex firstVertex) {
        this.firstVertex = firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(Vertex secondVertex) {
        this.secondVertex = secondVertex;
    }

    public int getDisparity() {
        return disparity;
    }

    public void setDisparity(int disparity) {
        this.disparity = disparity;
    }
}
