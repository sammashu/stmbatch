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

@Document(collection = "fareattributes")
@TypeAlias("fare_attributes")
public class FareAttributes extends AbstractBatchEntityCommon implements Serializable {

    private static final long serialVersionUID = 300L;

    @Field("fare_id")
    @Indexed(name = "fareId")
    private String fareId;

    @Field("price")
    private double price;

    @Field("currency_type")
    private String currencyType;

    @Field("payment_method")
    private int paymentMethod;

    @Field("transfers")
    private int transfers;

    @Field("transfer_duration")
    private int transferDuration;

    public FareAttributes() {
    }

    @PersistenceConstructor
    public FareAttributes(String fareId, double price, String currencyType, int paymentMethod, int transfers, int transferDuration) {
        setFareId(fareId);
        setPrice(price);
        setCurrencyType(currencyType);
        setPaymentMethod(paymentMethod);
        setTransfers(transfers);
        setTransferDuration(transferDuration);
    }

    public String getFareId() {
        return fareId;
    }

    public void setFareId(String fareId) {
        this.fareId = fareId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getTransfers() {
        return transfers;
    }

    public void setTransfers(int transfers) {
        this.transfers = transfers;
    }

    public int getTransferDuration() {
        return transferDuration;
    }

    public void setTransferDuration(int transferDuration) {
        this.transferDuration = transferDuration;
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.fareId, this.price, this.currencyType, this.paymentMethod, this.transfers, this.transferDuration);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(this == null || getClass() != obj.getClass()){
            return false;
        }

        FareAttributes that = (FareAttributes) obj;

        return Objects.equals(this.getFareId(), that.getFareId());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
                append("fareId",fareId).
                append("price",price).
                append("currencyType",currencyType).
                append("paymentMethod",paymentMethod).
                append("transfers",transfers).
                append("transferDuration",transferDuration).
                build();
    }
}
