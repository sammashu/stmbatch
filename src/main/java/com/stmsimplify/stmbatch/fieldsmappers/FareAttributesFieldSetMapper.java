package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.FareAttributes;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;

@Slf4j
public class FareAttributesFieldSetMapper implements FieldSetMapper<FareAttributes>, Serializable {

    private static final long serialVersionUID = 10002L;
    private static final String[] FIELD_NAMES =  new String[]{"fareId","price","currencyType","paymentMethod","transfers","transferDuration"};

    @Override
    public FareAttributes mapFieldSet(FieldSet fieldSet) throws BindException {
        FareAttributes fareAttributes = new FareAttributes();
        fareAttributes.setId(fieldSet.readString(FIELD_NAMES[0]));
        fareAttributes.setFareId(fieldSet.readString(FIELD_NAMES[0]));
        fareAttributes.setPrice(fieldSet.readDouble(FIELD_NAMES[1]));
        fareAttributes.setCurrencyType(fieldSet.readString(FIELD_NAMES[2]));
        fareAttributes.setPaymentMethod(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[3], 0));
        fareAttributes.setTransfers(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[4], 0));
        fareAttributes.setTransferDuration(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[5], 0));
        return fareAttributes;
    }
}
