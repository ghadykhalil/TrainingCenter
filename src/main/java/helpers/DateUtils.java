package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateUtils {

    private DateUtils() {
        // Private constructor to prevent instantiation of the utility class
    }

    public static Date parseDate(String dateString, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(dateString);
    }

    public static LocalDate parseLocalDate(String dateString, String format) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(dateString, formatter);
    }

    // Overloaded methods for common yyyy-MM-dd format
    public static Date parseDate(String dateString) throws ParseException {
        return parseDate(dateString, "yyyy-MM-dd");
    }

    public static LocalDate parseLocalDate(String dateString) throws DateTimeParseException {
        return parseLocalDate(dateString, "yyyy-MM-dd");
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String formatLocalDate(LocalDate localDate, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDate.format(formatter);
    }

    // Overloaded methods for common yyyy-MM-dd format
    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    public static String formatLocalDate(LocalDate localDate) {
        return formatLocalDate(localDate, "yyyy-MM-dd");
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

}
