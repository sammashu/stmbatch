package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.FareRules;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;
@Slf4j
public class FareRulesFieldSetMapper implements FieldSetMapper<FareRules>, Serializable {

    private static final long serialVersionUID = 10003L;

    private static final String[] FIELD_NAMES = new String[]{"fareId","routeId","originId","destinationId","containId"};

    @Override
    public FareRules mapFieldSet(FieldSet fieldSet) throws BindException {
        FareRules fareRules = new FareRules();
        fareRules.setId(fieldSet.readString(FIELD_NAMES[0]) + fieldSet.readString(FIELD_NAMES[1]));
        fareRules.setFareId(fieldSet.readString(FIELD_NAMES[0]));
        fareRules.setRouteId(UtilsCommon.getLong(fieldSet, FIELD_NAMES[1], 0L));
        fareRules.setOriginId(UtilsCommon.getLong(fieldSet,FIELD_NAMES[2], 0L));
        fareRules.setDestinationId(UtilsCommon.getLong(fieldSet,FIELD_NAMES[3], 0L));
        fareRules.setContainId(UtilsCommon.getLong(fieldSet,FIELD_NAMES[4], 0L));
        return fareRules;
    }
}
