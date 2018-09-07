package com.stmsimplify.stmbatch.models.key;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serializable;
import java.util.Objects;

public class StopTimesKey implements Serializable {

    private static final long serialVersionUID = 20000L;

    @Field("trip_id")
    @Indexed(name = "tripId")
    private String tripId;

    @Field("stop_id")
    @Indexed(name = "stopId")
    private long stopId;

    public StopTimesKey() {
    }

    @PersistenceConstructor
    public StopTimesKey(String tripId, long stopId) {
        this.tripId = tripId;
        this.stopId = stopId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.tripId, this.stopId);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        StopTimesKey that = (StopTimesKey) obj;

        return Objects.equals(this, that);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("tripId", tripId).
                append("stopId", stopId).
                build();
    }
}
