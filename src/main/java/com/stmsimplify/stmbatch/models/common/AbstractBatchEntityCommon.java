package com.stmsimplify.stmbatch.models.common;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mongostm")
public abstract class AbstractBatchEntityCommon {

    @Id
    private String id;

    public AbstractBatchEntityCommon() {

    }

    @PersistenceConstructor
    public AbstractBatchEntityCommon(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
