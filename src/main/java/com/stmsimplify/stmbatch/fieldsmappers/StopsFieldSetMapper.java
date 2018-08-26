package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.Stops;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import org.bson.types.ObjectId;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;
import java.util.Date;

public class StopsFieldSetMapper implements FieldSetMapper<Stops>, Serializable {

    private static final long serialVersionUID = 10007L;
    private static final String[] FIELD_NAMES =  new String[]{"stopId","stopCode","stopName","stopLat","stopLon","stopUrl","locationType","parentStation","wheelchairBoarding"};

    @Override
    public Stops mapFieldSet(FieldSet fieldSet) throws BindException {
        Stops stops = new Stops();
        stops.setId(fieldSet.readString(FIELD_NAMES[0]) + new ObjectId(new Date()));
        stops.setStopId(UtilsCommon.getLong(fieldSet, FIELD_NAMES[0], 0L));
        stops.setStopCode(UtilsCommon.getLong(fieldSet, FIELD_NAMES[1], 0L));
        stops.setStopName(fieldSet.readString(FIELD_NAMES[2]));
        stops.setStopLat(UtilsCommon.getDouble(fieldSet, FIELD_NAMES[3], 0d));
        stops.setStopLon(UtilsCommon.getDouble(fieldSet, FIELD_NAMES[4], 0d));
        stops.setStopUrl(fieldSet.readString(FIELD_NAMES[5]));
        stops.setLocationType(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[6], 0));
        stops.setParentStation(fieldSet.readString(FIELD_NAMES[7]));
        stops.setWheelchairBoarding(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[8], 0));
        return stops;
    }
}
