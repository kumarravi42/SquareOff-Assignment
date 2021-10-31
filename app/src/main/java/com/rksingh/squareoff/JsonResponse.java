package com.rksingh.squareoff;

public class JsonResponse {

    private Model[] trns;

    public Model[] getDataArray() {
        return trns;
    }

    public void setDataArray(Model[] dataArray) {
        this.trns = dataArray;
    }
}
