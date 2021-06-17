package br.com.gz.finance.apifinance.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class DateUtil {

    public static LocalDateTime transformLongToLocalDateTime(Long timestamp) {
        if (Objects.isNull(timestamp))
            return null;

        Date d = new Date(TimeUnit.SECONDS.toMillis(timestamp));
        return d.toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
    }

    public static LocalDateTime transformMillisToLocalDateTime(Long millis) {
        if (Objects.isNull(millis))
            return null;

        Date d = new Date(millis);
        return d.toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
    }

    public static LocalDate parseStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static String parseLocalDateTimeToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return date.format(formatter);
    }
}
