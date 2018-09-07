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
import java.util.Objects;

@Document(collection = "stops")
@TypeAlias("stops")
public class Stops extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 800L;

    @Field("stop_id")
    @Indexed(name = "stopId")
    private long stopId;

    @Field("stop_code")
    private long stopCode;

    @Field("stop_name")
    private String stopName;

    @Field("stop_lat")
    private double stopLat;

    @Field("stopLon")
    private double stopLon;

    @Field("stop_url")
    private String stopUrl;

    @Field("location_type")
    private int locationType;

    @Field("parentStation")
    private String parentStation;

    @Field("wheelchair_boarding")
    private int wheelchairBoarding;

    public Stops() {
    }

    @PersistenceConstructor
    public Stops(long stopId, long stopCode, String stopName, double stopLat, double stopLon, String stopUrl, int locationType, String parentStation, int wheelchairBoarding) {
        setStopId(stopId);
        setStopCode(stopCode);
        setStopName(stopName);
        setStopLat(stopLat);
        setStopLon(stopLon);
        setStopUrl(stopUrl);
        setLocationType(locationType);
        setParentStation(parentStation);
        setWheelchairBoarding(wheelchairBoarding);
    }

    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }

    public long getStopCode() {
        return stopCode;
    }

    public void setStopCode(long stopCode) {
        this.stopCode = stopCode;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public double getStopLat() {
        return stopLat;
    }

    public void setStopLat(double stopLat) {
        this.stopLat = stopLat;
    }

    public double getStopLon() {
        return stopLon;
    }

    public void setStopLon(double stopLon) {
        this.stopLon = stopLon;
    }

    public String getStopUrl() {
        return stopUrl;
    }

    public void setStopUrl(String stopUrl) {
        this.stopUrl = stopUrl;
    }

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }

    public String getParentStation() {
        return parentStation;
    }

    public void setParentStation(String parentStation) {
        this.parentStation = parentStation;
    }

    public int getWheelchairBoarding() {
        return wheelchairBoarding;
    }

    public void setWheelchairBoarding(int wheelchairBoarding) {
        this.wheelchairBoarding = wheelchairBoarding;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.stopId, this.stopCode, this.stopName, this.stopLat, this.stopLon, this.stopUrl, this.locationType, this.parentStation, this.wheelchairBoarding);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        Stops that = (Stops) obj;

        return Objects.equals(this.getStopId(), that.getStopId());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("stopId",stopId).
                append("stopCode",stopCode).
                append("stopName",stopName).
                append("stopLat",stopLat).
                append("stopLon",stopLon).
                append("stopUrl",stopUrl).
                append("locationType",locationType).
                append("parentStation",parentStation).
                append("wheelchairBoarding",wheelchairBoarding).
                build();
    }
}
