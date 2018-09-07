package com.stmsimplify.stmbatch.models;

import com.stmsimplify.stmbatch.models.common.AbstractBatchEntityCommon;
import com.stmsimplify.stmbatch.models.key.TripsKey;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "trips")
@TypeAlias("trips")
public class Trips extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 1000L;

    @Field("id_trips")
    @Indexed(name = "idTrips")
    private TripsKey idTrips;

    @Field("trip_headsign")
    private String tripHeadsign;

    @Field("direction_id")
    private int directionId;

    @Field("shape_id")
    private long shapeId;

    @Field("wheelchair_accessible")
    private int wheelchairAccessible;

    @Field("note_fr")
    private String noteFr;

    @Field("note_en")
    private String noteEn;

    public Trips() {
    }

    @PersistenceConstructor
    public Trips(TripsKey idTrips, String tripHeadsign, int directionId ,long shapeId, int wheelchairAccessible, String noteFr, String noteEn) {
        setIdTrips(idTrips);
        setTripHeadsign(tripHeadsign);
        setDirectionId(directionId);
        setShapeId(shapeId);
        setWheelchairAccessible(wheelchairAccessible);
        setNoteFr(noteFr);
        setNoteEn(noteEn);
    }

    public TripsKey getIdTrips() {
        return idTrips;
    }

    public void setIdTrips(TripsKey idTrips) {
        this.idTrips = idTrips;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    public long getShapeId() {
        return shapeId;
    }

    public void setShapeId(long shapeId) {
        this.shapeId = shapeId;
    }

    public int getWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(int wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public String getNoteFr() {
        return noteFr;
    }

    public void setNoteFr(String noteFr) {
        this.noteFr = noteFr;
    }

    public String getNoteEn() {
        return noteEn;
    }

    public void setNoteEn(String noteEn) {
        this.noteEn = noteEn;
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.idTrips, this.tripHeadsign, this.directionId ,this.shapeId,this.wheelchairAccessible, this.noteFr, this.noteEn);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        Trips that = (Trips) obj;

        return Objects.equals(this.getIdTrips(), that.getIdTrips());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("idTrips",idTrips).
                append("tripHeadsign",tripHeadsign).
                append("directionId",directionId).
                append("shapeId",shapeId).
                append("wheelchairAccessible",wheelchairAccessible).
                append("noteFr",noteFr).
                append("noteEn",noteEn).
                build();
    }
}
