package com.stmsimplify.stmbatch.models.key;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;

public class TripsKey implements Serializable {

    private static final long serialVersionUID = 10000L;

    @Field("route_id")
    @Indexed(name = "routeId")
    private long routeId;

    @Field("service_id")
    @Indexed(name = "serviceId")
    private String serviceId;

    @Field("trip_id")
    @Indexed(name = "tripId")
    private String tripId;

    public TripsKey() {
    }

    @PersistenceConstructor
    public TripsKey(long routeId, String serviceId, String tripId) {
        this.routeId = routeId;
        this.serviceId = serviceId;
        this.tripId = tripId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.routeId, this.serviceId, this.tripId);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        TripsKey that = (TripsKey) obj;
        return Objects.equals(this, that);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("routeId",routeId).
                append("serviceId",serviceId).
                append("tripId",tripId).
                build();
    }
}
