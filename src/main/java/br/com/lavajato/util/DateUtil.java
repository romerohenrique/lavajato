package br.com.lavajato.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    public static String formatLocalDateTimeToDataBaseStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss").format(localDateTime);
    }
}
