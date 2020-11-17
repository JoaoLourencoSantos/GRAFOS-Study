package com.company.domain;

public class Matrix {

    private int firstAreaId;
    private int secondAreaId;

    private int disparity;

    public Matrix(int firstAreaId, int secondAreaId, int disparity) {
        this.firstAreaId = firstAreaId;
        this.secondAreaId = secondAreaId;
        this.disparity = disparity;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "firstAreaId=" + firstAreaId +
                ", secondAreaId=" + secondAreaId +
                ", disparity=" + disparity +
                '}';
    }
}
