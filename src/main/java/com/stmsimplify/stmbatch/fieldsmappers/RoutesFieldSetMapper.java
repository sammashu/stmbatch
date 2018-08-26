package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.Routes;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;

public class RoutesFieldSetMapper implements FieldSetMapper<Routes>, Serializable {

    private static final long serialVersionUID = 10005L;
    private static final String[] FIELD_NAMES =  new String[]{"routeId","agencyId","routeShortName","routeLongName","routeTYpe","routeUrl","routeColor","routeTextColor"};

    @Override
    public Routes mapFieldSet(FieldSet fieldSet) throws BindException {
        Routes routes = new Routes();
        routes.setId(fieldSet.readString(FIELD_NAMES[0])+ fieldSet.readString(FIELD_NAMES[1]));
        routes.setRouteId(UtilsCommon.getLong(fieldSet, FIELD_NAMES[0], 0L));
        routes.setAgencyId(fieldSet.readString(FIELD_NAMES[1]));
        routes.setRouteShortName(fieldSet.readString(FIELD_NAMES[2]));
        routes.setRouteLongName(fieldSet.readString(FIELD_NAMES[3]));
        routes.setRouteType(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[4], 0));
        routes.setRouteUrl(fieldSet.readString(FIELD_NAMES[5]));
        routes.setRouteColor(fieldSet.readString(FIELD_NAMES[6]));
        routes.setRouteTextColor(fieldSet.readString(FIELD_NAMES[7]));
        return routes;
    }
}
