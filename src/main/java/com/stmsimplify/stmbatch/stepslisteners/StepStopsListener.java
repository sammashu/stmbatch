package com.stmsimplify.stmbatch.stepslisteners;

import com.stmsimplify.stmbatch.fieldsmappers.StopsFieldSetMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StepStopsListener implements StepExecutionListener {
    private static final String FILENAME = "stops.csv";
    private static final String DELIMITER = ",";
    private static final String[] FIELD_NAMES =  new String[]{"stopId","stopCode","stopName","stopLat","stopLon","stopUrl","locationType","parentStation","wheelchairBoarding"};

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Stops listener step call");
        stepExecution.getExecutionContext().putString("fileName", FILENAME);
        stepExecution.getExecutionContext().putString("delimiter", DELIMITER);
        stepExecution.getExecutionContext().put("fieldNames", FIELD_NAMES);
        stepExecution.getExecutionContext().put("fieldSetMapper", new StopsFieldSetMapper());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
