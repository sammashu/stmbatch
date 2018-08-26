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

@Document(collection = "mongostm")
@TypeAlias("shapes")
public class Shapes extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 700L;

    @Field("shape_id")
    @Indexed(name = "shapeId")
    private long shapeId;

    @Field("shape_pt_lat")
    private double shapePtLat;

    @Field("shape_pt_lon")
    private double shapePtLon;

    @Field("shape_pt_sequence")
    private long shapePtSequence;

    public Shapes() {
    }

    @PersistenceConstructor
    public Shapes(long shapeId, double shapePtLat, double shapePtLon, long shapePtSequence) {
        setShapeId(shapeId);
        setShapePtLat(shapePtLat);
        setShapePtLon(shapePtLon);
        setShapePtSequence(shapePtSequence);
    }

    public long getShapeId() {
        return shapeId;
    }

    public void setShapeId(long shapeId) {
        this.shapeId = shapeId;
    }

    public double getShapePtLat() {
        return shapePtLat;
    }

    public void setShapePtLat(double shapePtLat) {
        this.shapePtLat = shapePtLat;
    }

    public double getShapePtLon() {
        return shapePtLon;
    }

    public void setShapePtLon(double shapePtLon) {
        this.shapePtLon = shapePtLon;
    }

    public long getShapePtSequence() {
        return shapePtSequence;
    }

    public void setShapePtSequence(long shapePtSequence) {
        this.shapePtSequence = shapePtSequence;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.shapeId, this.shapePtLat, this.shapePtLon, this.shapePtSequence);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(this == null | getClass() != obj.getClass()){
            return false;
        }

        Shapes that = (Shapes) obj;

        return Objects.equals(this.getShapeId(), that.getShapeId());
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("shapeId",shapeId).
                append("shapePtLat",shapePtLat).
                append("shapePtLon",shapePtLon).
                append("shapePtSequence",shapePtSequence).
                build();
    }
}
