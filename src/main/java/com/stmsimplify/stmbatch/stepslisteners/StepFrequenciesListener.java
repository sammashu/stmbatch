package com.stmsimplify.stmbatch.stepslisteners;

import com.stmsimplify.stmbatch.fieldsmappers.FrequenciesFieldSetMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StepFrequenciesListener implements StepExecutionListener {
    private static final String FILENAME = "frequencies.csv";
    private static final String DELIMITER = ",";
    private static final String[] FIELD_NAMES =  new String[]{"tripId","startTime","endTime","headwaySecs"};

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Frequencies listener step call");
        stepExecution.getExecutionContext().putString("fileName", FILENAME);
        stepExecution.getExecutionContext().putString("delimiter", DELIMITER);
        stepExecution.getExecutionContext().put("fieldNames", FIELD_NAMES);
        stepExecution.getExecutionContext().put("fieldSetMapper", new FrequenciesFieldSetMapper());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
