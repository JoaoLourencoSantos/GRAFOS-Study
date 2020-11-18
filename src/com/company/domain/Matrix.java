package com.company.domain;

public class Matrix {

    private Integer firstAreaId;
    private Integer secondAreaId;

    private Integer disparity;

    public Matrix(Integer firstAreaId, Integer secondAreaId, Integer disparity) {
        this.firstAreaId = firstAreaId;
        this.secondAreaId = secondAreaId;
        this.disparity = disparity;
    }

    public Integer getFirstAreaId() {
        return firstAreaId;
    }

    public void setFirstAreaId(int firstAreaId) {
        this.firstAreaId = firstAreaId;
    }

    public Integer getSecondAreaId() {
        return secondAreaId;
    }

    public void setSecondAreaId(int secondAreaId) {
        this.secondAreaId = secondAreaId;
    }

    public Integer getDisparity() {
        return disparity;
    }

    public void setDisparity(int disparity) {
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
