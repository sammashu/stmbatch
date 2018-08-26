package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.Frequencies;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import org.bson.types.ObjectId;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;
import java.util.Date;

public class FrequenciesFieldSetMapper implements FieldSetMapper<Frequencies>, Serializable {

    private static final long serialVersionUID = 10004L;
    private static final String[] FIELD_NAMES =  new String[]{"tripId","startTime","endTime","headwaySecs"};

    @Override
    public Frequencies mapFieldSet(FieldSet fieldSet) throws BindException {
        Frequencies frequencies = new Frequencies();
        frequencies.setId(fieldSet.readString(FIELD_NAMES[0]) + new ObjectId(new Date()));
        frequencies.setTripId(fieldSet.readString(FIELD_NAMES[0]));
        frequencies.setStartTime(UtilsCommon.convertStringTimeToDate(fieldSet.readString(FIELD_NAMES[1])));
        frequencies.setEndTime(UtilsCommon.convertStringTimeToDate(fieldSet.readString(FIELD_NAMES[2])));
        frequencies.setHeadwaySecs(UtilsCommon.getInteger(fieldSet,FIELD_NAMES[3],0));
        return frequencies;
    }
}
