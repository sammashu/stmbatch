package com.stmsimplify.stmbatch.stepslisteners;

import com.stmsimplify.stmbatch.fieldsmappers.FareAttributesFieldSetMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StepFareAttributesListener implements StepExecutionListener {

    private static final String FILENAME = "fare_attributes.csv";
    private static final String DELIMITER = ",";
    private static final String[] FIELD_NAMES =  new String[]{"fareId","price","currencyType","paymentMethod","transfers","transferDuration"};

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Fare Attributes listener step call");
        stepExecution.getExecutionContext().putString("fileName", FILENAME);
        stepExecution.getExecutionContext().putString("delimiter", DELIMITER);
        stepExecution.getExecutionContext().put("fieldNames", FIELD_NAMES);
        stepExecution.getExecutionContext().put("fieldSetMapper", new FareAttributesFieldSetMapper());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
