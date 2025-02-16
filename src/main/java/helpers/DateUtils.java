package helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateUtils {

    private DateUtils() {
        // Private constructor to prevent instantiation of the utility class
    }

    // =================== Date Parsing Methods ===================
    public static Date parseDate(String dateString, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(dateString);
    }

    public static LocalDate parseLocalDate(String dateString, String format) throws DateTimeParseException {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(format));
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeString, String format) throws DateTimeParseException {
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(format));
    }

    // Overloaded methods for common formats
    public static Date parseDate(String dateString) throws ParseException {
        return parseDate(dateString, "yyyy-MM-dd");
    }

    public static LocalDate parseLocalDate(String dateString) throws DateTimeParseException {
        return parseLocalDate(dateString, "yyyy-MM-dd");
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeString) throws DateTimeParseException {
        return parseLocalDateTime(dateTimeString, "yyyy-MM-dd HH:mm:ss");
    }

    // =================== Date Formatting Methods ===================
    public static String formatDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String formatLocalDate(LocalDate localDate, String format) {
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime, String format) {
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    // Overloaded methods for common formats
    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    public static String formatLocalDate(LocalDate localDate) {
        return formatLocalDate(localDate, "yyyy-MM-dd");
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return formatLocalDateTime(localDateTime, "yyyy-MM-dd HH:mm:ss");
    }

    // =================== Date Conversions ===================
    public static Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
