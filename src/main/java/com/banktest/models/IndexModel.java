package com.banktest.models;

public class IndexModel {
    private long id;

    public IndexModel(long id) {
        this.id = id + 40;
    }

    public long getId(){
        return id;
    }
}
