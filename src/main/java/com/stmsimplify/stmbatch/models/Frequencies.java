package com.stmsimplify.stmbatch.models;

import com.stmsimplify.stmbatch.models.common.AbstractBatchEntityCommon;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "frequencies")
@TypeAlias("frequencies")
public class Frequencies extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 500L;

    @Field("trip_id")
    @Indexed(name = "tripId")
    private String tripId;

    @Field("start_time")
    private Date startTime;

    @Field("end_time")
    private Date endTime;

    @Field("headway_secs")
    private int headwaySecs;

    public Frequencies() {
    }

    @PersistenceConstructor
    public Frequencies(String tripId, Date startTime, Date endTime, int headwaySecs) {
        setTripId(tripId);
        setStartTime(startTime);
        setEndTime(endTime);
        setHeadwaySecs(headwaySecs);
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getHeadwaySecs() {
        return headwaySecs;
    }

    public void setHeadwaySecs(int headwaySecs) {
        this.headwaySecs = headwaySecs;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tripId, this.startTime, this.endTime, this.headwaySecs);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        Frequencies that = (Frequencies) obj;

        return Objects.equals(this.getTripId(), that.getTripId());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("tripId",tripId).
                append("startTime",startTime).
                append("endTime",endTime).
                append("headwaySecs",headwaySecs).
                build();
    }

}
