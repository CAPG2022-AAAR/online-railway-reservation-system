package com.orrs.availabletraininfo.details;

public class CatalogItem {

    private String trainname;
    private  int trainid;

    public CatalogItem(String trainname, int trainid) {
        this.trainname = trainname;
        this.trainid = trainid;
    }

    public String getTrainname() {
        return trainname;
    }

    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }

    public int getTrainid() {
        return trainid;
    }

    public void setTrainid(int trainid) {
        this.trainid = trainid;
    }
}
