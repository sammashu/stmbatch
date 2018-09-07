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

@Document(collection = "agency")
@TypeAlias("agency")
public class Agency extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 100L;

    @Field("agency_id")
    @Indexed(name="agencyId")
    private String agencyId;

    @Field("agency_name")
    private String agencyName;

    @Field("agency_url")
    private String agencyUrl;

    @Field("agency_timezone")
    private String agencyTimezone;

    @Field("agency_lang")
    private String agencyLang;

    @Field("agency_phone")
    private String agencyPhone;

    @Field("agency_fare_url")
    private String agencyFareUrl;

    public Agency() {

    }

    @PersistenceConstructor
    public Agency(String agencyId, String agencyName, String agencyUrl, String agencyTimezone, String agencyLang, String agencyPhone ,String agencyFareUrl) {
        setAgencyId(agencyId);
        setAgencyName(agencyName);
        setAgencyUrl(agencyUrl);
        setAgencyTimezone(agencyTimezone);
        setAgencyLang(agencyLang);
        setAgencyPhone(agencyPhone);
        setAgencyFareUrl(agencyFareUrl);
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }

    public void setAgencyUrl(String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    public String getAgencyTimezone() {
        return agencyTimezone;
    }

    public void setAgencyTimezone(String agencyTimezone) {
        this.agencyTimezone = agencyTimezone;
    }

    public String getAgencyLang() {
        return agencyLang;
    }

    public void setAgencyLang(String agencyLang) {
        this.agencyLang = agencyLang;
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    public String getAgencyFareUrl() {
        return agencyFareUrl;
    }

    public void setAgencyFareUrl(String agencyFareUrl) {
        this.agencyFareUrl = agencyFareUrl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.agencyId, this.agencyName, this.agencyUrl, this.agencyTimezone, this.agencyLang, this.agencyPhone,this.agencyFareUrl);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        final Agency that = (Agency) obj;

        return Objects.equals(this.getAgencyName(), that.getAgencyName());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("agencyId",agencyId).
                append("agencyName",agencyName).
                append("agencyUrl",agencyUrl).
                append("agencyTimezone",agencyTimezone).
                append("agencyLang",agencyLang).
                append("agencyPhone",agencyPhone).
                append("agencyFareUrl",agencyFareUrl)
                .build();
    }
}
