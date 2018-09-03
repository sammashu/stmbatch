package com.stmsimplify.stmbatch.writer;


import com.stmsimplify.stmbatch.models.common.AbstractBatchEntityCommon;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.data.mongodb.core.BulkOperations;

import java.util.List;


@Slf4j
public class MongoBulkItemWriter<T extends AbstractBatchEntityCommon> extends MongoItemWriter<T> {

    private Class<T> modelClass;

    public MongoBulkItemWriter(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    //Its recommend to use BulkOperation for a lot of data that need to be manipulate for performance
    @Override
    public void write(List<? extends T> items) {
        BulkOperations bulkOp = this.getTemplate().bulkOps(BulkOperations.BulkMode.UNORDERED, modelClass);
        try {
            items.forEach(i -> {
                //log.info("documentID:{}",i.toString());
                Document doc = new Document();
                this.getTemplate().getConverter().write(i, doc);   //convert your data and bind to the document.
                bulkOp.insert(doc);
            });
            bulkOp.execute();
        }
        catch(Exception e){
            log.error("DATA FAIL -> {} ", e.getMessage());
        }
    }

}
