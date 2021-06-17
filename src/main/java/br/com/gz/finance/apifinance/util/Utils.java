package br.com.gz.finance.apifinance.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class Utils {

    public static String getLocalDateTime() {
        return DateUtil.parseLocalDateTimeToString(LocalDateTime.now());
    }
}
