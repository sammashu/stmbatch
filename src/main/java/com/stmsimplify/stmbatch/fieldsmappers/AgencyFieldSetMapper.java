package com.stmsimplify.stmbatch.fieldsmappers;

import com.stmsimplify.stmbatch.models.Agency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.io.Serializable;

@Slf4j
public class AgencyFieldSetMapper  implements FieldSetMapper<Agency>, Serializable {

    private static final long serialVersionUID = 10000L;

    private static final String[] FIELD_NAMES = new String[]{"agencyId", "agencyName", "agencyUrl", "agencyTimezone", "agencyLang", "agencyPhone", "agencyFareUrl"};

    @Override
    public Agency mapFieldSet(FieldSet fieldSet) throws BindException {
        Agency agency = new Agency();
        agency.setId(fieldSet.readString(FIELD_NAMES[0]));
        agency.setAgencyId(fieldSet.readString(FIELD_NAMES[0]));
        agency.setAgencyName(fieldSet.readString(FIELD_NAMES[1]));
        agency.setAgencyUrl(fieldSet.readString(FIELD_NAMES[2]));
        agency.setAgencyTimezone(fieldSet.readString(FIELD_NAMES[3]));
        agency.setAgencyLang(fieldSet.readString(FIELD_NAMES[4]));
        agency.setAgencyPhone(fieldSet.readString(FIELD_NAMES[5]));
        agency.setAgencyFareUrl(fieldSet.readString(FIELD_NAMES[6]));
        return agency;
    }
}
