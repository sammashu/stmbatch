package com.stmsimplify.stmbatch.utils.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.file.transform.FieldSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

@Slf4j
public class UtilsCommon {

    /**
     * This function convert a string date format yyyyMMdd to a object Date
     * @param date
     * @return
     */
    public static Date convertStringYYYYMMDDToDate(String date) {
        try {
            return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(date);
        } catch (ParseException e) {
            log.error("Cannot parse date string -> "+ e.getMessage());
        }
        return null;
    }

    /**
     * this function convert string time to Object date
     *
     * @param time
     * @return
     */
    public static Date convertStringTimeToDate(String time) {
        try {
            return new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH).parse(time);
        } catch (ParseException e) {
            log.error("Cannot parse time string -> "+ e.getMessage());
        }
        return null;
    }

    /**
     * This function is for FieldSetMapper setting converting into a int value validate also if empty will set by default value specific
     * @param fs
     * @param key
     * @param defaultV
     * @return
     */
    public static Integer getInteger(FieldSet fs, String key, Integer defaultV) {
        if(StringUtils.isNumeric(fs.readString(key))) {
            return fs.readInt(key);
        } else {
            return defaultV;
        }
    }

    /**
     * This function is for FieldSetMapper setting converting into a long value validate also if empty will set by default value specific
     * @param fs
     * @param key
     * @param defaultV
     * @return
     */
    public static Long getLong(FieldSet fs, String key, Long defaultV) {
        if(StringUtils.isNumeric(fs.readString(key))) {
            return fs.readLong(key);
        } else {
            return defaultV;
        }
    }

    /**
     * This function is for FieldSetMapper setting converting into a double value validate also if empty will set by default value specific
     * @param fs
     * @param key
     * @param defaultV
     * @return
     */
    public static Double getDouble(FieldSet fs, String key, Double defaultV) {
        if(Objects.nonNull(fs.readString(key))) {
            return fs.readDouble(key);
        } else {
            return defaultV;
        }
    }
}
