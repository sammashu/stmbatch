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
@TypeAlias("routes")
public class Routes extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 600L;

    @Field("route_id")
    @Indexed(name = "routeId")
    private long routeId;

    @Field("agency_id")
    @Indexed(name = "agencyId")
    private String agencyId;

    @Field("route_short_name")
    private String routeShortName;

    @Field("route_long_name")
    private String routeLongName;

    @Field("route_type")
    private int routeType;

    @Field("route_url")
    private String routeUrl;

    @Field("route_color")
    private String routeColor;

    @Field("route_text_color")
    private String routeTextColor;

    public Routes() {
    }

    @PersistenceConstructor
    public Routes(long routeId, String agencyId, String routeShortName, String routeLongName, int routeType, String routeUrl, String routeColor, String routeTextColor) {
        setRouteId(routeId);
        setAgencyId(agencyId);
        setRouteShortName(routeShortName);
        setRouteLongName(routeLongName);
        setRouteType(routeType);
        setRouteUrl(routeUrl);
        setRouteColor(routeColor);
        setRouteTextColor(routeTextColor);
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public int getRouteType() {
        return routeType;
    }

    public void setRouteType(int routeType) {
        this.routeType = routeType;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public void setRouteUrl(String routeUrl) {
        this.routeUrl = routeUrl;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    public void setRouteTextColor(String routeTextColor) {
        this.routeTextColor = routeTextColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.routeId, this.agencyId, this.routeShortName, this.routeLongName, this.routeType, this.routeUrl, this.routeColor, this.routeTextColor);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        Routes that = (Routes) obj;

        return Objects.equals(this.getRouteId(), that.getRouteId());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("routeId",routeId).
                append("agencyId",agencyId).
                append("routeShortName",routeShortName).
                append("routeLongName",routeLongName).
                append("routeType",routeType).
                append("routeUrl",routeUrl).
                append("routeColor",routeColor).
                append("routeTextColor",routeTextColor).
                build();
    }

}
