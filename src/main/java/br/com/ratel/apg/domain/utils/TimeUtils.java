package br.com.ratel.apg.domain.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TimeUtils {
    private static final ZoneId ZONE_ID = ZoneId.of("America/Maceio");

    public static LocalDateTime startOfDay() {
        return nowDate().atStartOfDay();
    }

    public static LocalDateTime endOfDay() {
        return nowDate().atTime(23, 59, 59);
    }

    public static LocalDate nowDate() {
        return LocalDate.now(ZONE_ID);
    }

    public static LocalDateTime nowDateTime() {
        return LocalDateTime.now(ZONE_ID);
    }

    public static String formattedDate(LocalDateTime dateTime) {
        return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy",
            new Locale("pt", "BR")));
    }
}
