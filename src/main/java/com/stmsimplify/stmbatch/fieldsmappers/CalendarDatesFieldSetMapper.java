package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.CalendarDates;
import com.stmsimplify.stmbatch.utils.common.UtilsCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;

@Slf4j
public class CalendarDatesFieldSetMapper implements FieldSetMapper<CalendarDates>, Serializable {

    private static final long serialVersionUID = 10001L;
    private static final String[] FIELD_NAMES =  new String[]{"serviceId","date","exceptionType"};

    @Override
    public CalendarDates mapFieldSet(FieldSet fieldSet) throws BindException {
        CalendarDates calendarDates = new CalendarDates();
        calendarDates.setId(fieldSet.readString(FIELD_NAMES[0])+fieldSet.readString(FIELD_NAMES[1]));
        calendarDates.setServiceId(fieldSet.readString(FIELD_NAMES[0]));
        calendarDates.setDate(UtilsCommon.convertStringYYYYMMDDToDate(fieldSet.readString(FIELD_NAMES[1])));
        calendarDates.setExceptionType(UtilsCommon.getInteger(fieldSet, FIELD_NAMES[2], 0));
        return calendarDates;
    }

}
