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


@Document(collection = "calendardates")
@TypeAlias("calendar_dates")
public class CalendarDates extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 200L;

    @Field("service_id")
    @Indexed(name = "serviceId")
    private String serviceId;

    @Field("date")
    private Date date;

    @Field("exception_type")
    private int exceptionType;

    public  CalendarDates(){
    }

    @PersistenceConstructor
    public CalendarDates(String serviceId, Date date, int exceptionType) {
        setServiceId(serviceId);
        setDate(date);
        setExceptionType(exceptionType);
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(int exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.serviceId, this.date, this.exceptionType);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        CalendarDates that = (CalendarDates) obj;

        return Objects.equals(this.getServiceId(), that.getServiceId());
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("serviceId",serviceId).
                append("date",date).
                append("exception",exceptionType).
                build();
    }

}
