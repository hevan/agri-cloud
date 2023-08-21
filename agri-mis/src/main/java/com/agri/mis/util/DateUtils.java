package com.agri.mis.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DateUtils {
    public static final String DEFAULT_YEAR_MONTH_FORMAT = "yyyyMM";
    public static final String DEFAULT_FROMAT_RANDOM = "yyyyMMddHHmmss";
    public static String formatYearMonth(LocalDate curDate) {
        return  DateTimeFormatter.ofPattern(DEFAULT_YEAR_MONTH_FORMAT).format(curDate);
    }

    public static String formatRandom(LocalDateTime nowDateTime) {
        return DateTimeFormatter.ofPattern(DEFAULT_FROMAT_RANDOM).format(nowDateTime);
    }

    public static String genBusiCode(String pre, LocalDateTime nowDateTime) {
        return pre + DateTimeFormatter.ofPattern(DEFAULT_FROMAT_RANDOM).format(nowDateTime)+createRandomNumber(6);
    }

    public static String createRandomNumber(int length) {
        StringBuilder strBuffer = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < length; i++) {
            strBuffer.append(rd.nextInt(10));
        }
        return strBuffer.toString();
    }

}
