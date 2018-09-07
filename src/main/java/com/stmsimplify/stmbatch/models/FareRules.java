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

@Document(collection = "farerules")
@TypeAlias("fare_rules")
public class FareRules extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 400L;

    @Field("fare_id")
    @Indexed(name = "fareId")
    private String fareId;

    @Field("route_id")
    @Indexed(name = "routeIdFareRules")
    private long routeId;

    @Field("origin_id")
    private long originId;

    @Field("destination_id")
    private long destinationId;

    @Field("contain_id")
    private long containId;

    public FareRules() {
    }

    @PersistenceConstructor
    public FareRules(String fareId, long routeId, long originId, long destinationId, long containId) {
        setFareId(fareId);
        setRouteId(routeId);
        setOriginId(originId);
        setDestinationId(destinationId);
        setContainId(containId);
    }

    public String getFareId() {
        return fareId;
    }

    public void setFareId(String fareId) {
        this.fareId = fareId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public long getOriginId() {
        return originId;
    }

    public void setOriginId(long originId) {
        this.originId = originId;
    }

    public long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(long destinationId) {
        this.destinationId = destinationId;
    }

    public long getContainId() {
        return containId;
    }

    public void setContainId(long containId) {
        this.containId = containId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.fareId, this.routeId, this.originId, this.destinationId, this.containId);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        FareRules that = (FareRules) obj;

        return Objects.equals(this.getFareId()+this.getRouteId(), that.getFareId()+that.getRouteId());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("fareId",fareId).
                append("routeId",routeId).
                append("originId",originId).
                append("destinationId",destinationId).
                append("containId",containId).
                build();
    }
}
