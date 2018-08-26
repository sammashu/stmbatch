package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.StopTimes;
import com.stmsimplify.stmbatch.models.key.StopTimesKey;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import org.bson.types.ObjectId;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;
import java.util.Date;


public class StopTimesFieldSetMapper implements FieldSetMapper<StopTimes>, Serializable {

    private static final long serialVersionUID = 10008L;
    private static final String[] FIELD_NAMES =  new String[]{"tripId","arrivalTime","departureTime","stopId","stopSequence"};

    @Override
    public StopTimes mapFieldSet(FieldSet fieldSet) throws BindException {
        StopTimes stopTimes = new StopTimes();
        StopTimesKey stopTimesKey = new StopTimesKey();
        stopTimesKey.setTripId(fieldSet.readString(FIELD_NAMES[0]));
        stopTimesKey.setStopId(UtilsCommon.getLong(fieldSet,FIELD_NAMES[3], 0L));
        stopTimes.setId(fieldSet.readString(FIELD_NAMES[0]) + fieldSet.readString(FIELD_NAMES[3]) + new ObjectId(new Date()));
        stopTimes.setIdStopTimes(stopTimesKey);
        stopTimes.setArrivalTime(UtilsCommon.convertStringTimeToDate(fieldSet.readString(FIELD_NAMES[1])));
        stopTimes.setDepartureTime(UtilsCommon.convertStringTimeToDate(fieldSet.readString(FIELD_NAMES[2])));
        stopTimes.setStopSequence(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[4], 0));
        return stopTimes;
    }
}
