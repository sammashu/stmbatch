package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.Trips;
import com.stmsimplify.stmbatch.models.key.TripsKey;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import org.bson.types.ObjectId;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;
import java.util.Date;

public class TripsFieldSetMapper implements FieldSetMapper<Trips>, Serializable {

    private static final long serialVersionUID = 10009L;
    private static final String[] FIELD_NAMES =  new String[]{"routeId","serviceId","tripId","tripHeadsign","directionId","shapeId","wheelchairAccessible","noteFr","noteEn"};

    @Override
    public Trips mapFieldSet(FieldSet fieldSet) throws BindException {
        Trips trips = new Trips();
        trips.setId(fieldSet.readString(FIELD_NAMES[0]) + fieldSet.readString(FIELD_NAMES[1]) + fieldSet.readString(FIELD_NAMES[3]) + new ObjectId(new Date()));
        TripsKey tripsKey = new TripsKey();
        tripsKey.setRouteId(UtilsCommon.getLong(fieldSet, FIELD_NAMES[0], 0L));
        tripsKey.setServiceId(fieldSet.readString(FIELD_NAMES[1]));
        tripsKey.setTripId(fieldSet.readString(FIELD_NAMES[2]));
        trips.setIdTrips(tripsKey);
        trips.setTripHeadsign(fieldSet.readString(FIELD_NAMES[3]));
        trips.setDirectionId(UtilsCommon.getInteger(fieldSet,FIELD_NAMES[4], 0));
        trips.setShapeId(UtilsCommon.getLong(fieldSet,FIELD_NAMES[5], 0L));
        trips.setWheelchairAccessible(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[6], 0));
        trips.setNoteFr(fieldSet.readString(FIELD_NAMES[7]));
        trips.setNoteEn(fieldSet.readString(FIELD_NAMES[8]));
        return trips;
    }
}
