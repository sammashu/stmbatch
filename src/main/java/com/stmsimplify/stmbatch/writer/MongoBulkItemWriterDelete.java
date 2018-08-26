package com.stmsimplify.stmbatch.writer;

import com.stmsimplify.stmbatch.models.common.AbstractBatchEntityCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.data.MongoItemWriter;

import java.util.List;

@Slf4j
public class MongoBulkItemWriterDelete<T extends AbstractBatchEntityCommon> extends MongoItemWriter<T> {

    private Class<T> modelClass;

    public MongoBulkItemWriterDelete(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    //No need to loop we just delete the collection here
    @Override
    public void write(List<? extends T> items) {
        try {
            this.getTemplate().dropCollection(modelClass);
        }
        catch(Exception e){
            log.error("DATA FAIL -> {} ", e.getMessage());
        }
    }
}
