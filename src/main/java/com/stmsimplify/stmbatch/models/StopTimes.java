package com.stmsimplify.stmbatch.models;

import com.stmsimplify.stmbatch.models.common.AbstractBatchEntityCommon;
import com.stmsimplify.stmbatch.models.key.StopTimesKey;
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

@Document(collection = "stoptimes")
@TypeAlias("stop_times")
public class StopTimes extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 900L;

    @Field("id_stop_times")
    @Indexed(name = "idStopTimes")
    private StopTimesKey idStopTimes;

    @Field("arrival_time")
    private Date arrivalTime;

    @Field("departure_time")
    private Date departureTime;

    @Field("stop_sequence")
    private int stopSequence;

    public StopTimes() {
    }

    @PersistenceConstructor
    public StopTimes(StopTimesKey idStopTimes, Date arrivalTime, Date departureTime, int stopSequence) {
        setIdStopTimes(idStopTimes);
        setArrivalTime(arrivalTime);
        setDepartureTime(departureTime);
        setStopSequence(stopSequence);
    }

    public StopTimesKey getIdStopTimes() {
        return idStopTimes;
    }

    public void setIdStopTimes(StopTimesKey idStopTimes) {
        this.idStopTimes = idStopTimes;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }


    public int getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(int stopSequence) {
        this.stopSequence = stopSequence;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.idStopTimes, this.arrivalTime, this.departureTime, this.stopSequence);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        StopTimes that = (StopTimes) obj;

        return Objects.equals(this.getIdStopTimes(), that.getIdStopTimes());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("idStopTimes",idStopTimes).
                append("arrivalTime",arrivalTime).
                append("departureTime",departureTime).
                append("stopSequence",stopSequence).
                build();
    }

}
