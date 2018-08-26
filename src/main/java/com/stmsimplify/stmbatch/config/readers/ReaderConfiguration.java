package com.stmsimplify.stmbatch.config.readers;

import com.stmsimplify.stmbatch.reader.DefaultFlatItemReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Slf4j
@Configuration
public class ReaderConfiguration {
    // the value fileName and delimiter got inject from the the stepExecutionContext we use the step listener to initialize them.

    @SuppressWarnings("unchecked")
    @Bean(destroyMethod = "")
    @StepScope
    public DefaultFlatItemReader defaultFlatItemReader(@Value("#{stepExecutionContext['fileName']}") String fileName, @Value("#{stepExecutionContext['delimiter']}") String delimiter, @Value("#{stepExecutionContext['fieldNames']}") String[] fieldNames, @Value("#{stepExecutionContext['fieldSetMapper']}") FieldSetMapper fieldSetMapper){
        log.info("fileName:{}", fileName);
        log.info("delimiter:{}", delimiter);
        log.info("fieldNames:{}", Arrays.toString(fieldNames));
        return new DefaultFlatItemReader(fileName, delimiter, fieldNames, fieldSetMapper);
    }

}
