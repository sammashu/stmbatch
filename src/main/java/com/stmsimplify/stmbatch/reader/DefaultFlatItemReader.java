package com.stmsimplify.stmbatch.reader;

import com.stmsimplify.stmbatch.models.common.AbstractBatchEntityCommon;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;


// This is the default reader generic.
public class DefaultFlatItemReader<T extends AbstractBatchEntityCommon> extends FlatFileItemReader<T> {

    protected String delimiter;

    public DefaultFlatItemReader(String fileName, String delimiter, String[] fieldNames, FieldSetMapper fieldSetMapper){

        this.delimiter = delimiter;
        this.setLinesToSkip(1);
        this.setResource(new ClassPathResource("data/" + fileName));

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(delimiter);
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(fieldNames);

        DefaultLineMapper lineMapper = new DefaultLineMapper<T>();
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        this.setLineMapper(lineMapper);
        this.setEncoding(StandardCharsets.ISO_8859_1.name());
    }

}
