package com.agri.mis.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static final String DEFAULT_YEAR_MONTH_FORMAT = "yyyyMM";
    public static final String DEFAULT_FROMAT_RANDOM = "yyMMddHHmmss";
    public static String formatYearMonth(LocalDate curDate) {
        return  DateTimeFormatter.ofPattern(DEFAULT_YEAR_MONTH_FORMAT).format(curDate);
    }

    public static String formatRandom(LocalDateTime nowDateTime) {
        return DateTimeFormatter.ofPattern(DEFAULT_FROMAT_RANDOM).format(nowDateTime);
    }
}
