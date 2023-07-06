package MateAcademy.Java8.Part3;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeApi {
    /**
     * Return the current date as a String depending on a query.
     * <p>
     * The query can be passed for the whole date or for it's part:
     * - FULL - current date as a whole: year, month, day of month
     * formatted as `YYYY-MM-DD` (a default return value);
     * - YEAR - current year;
     * - MONTH - name of the current month;
     * - DAY - current day of month;
     * In any other case throw DateTimeException.
     **/
    public static String todayDate(DateTimePart datePart) {
        LocalDate localDate = LocalDate.now();
        switch (datePart) {
            case DAY:
                return String.valueOf(localDate.getDayOfMonth());
            case MONTH:
                return String.valueOf(localDate.getMonth());
            case YEAR:
                return String.valueOf(localDate.getYear());
            case FULL:
                return localDate.format(DateTimeFormatter
                        .ofPattern("yyyy-MM-dd"));
            default:
                throw new DateTimeException("Date Time Exception");
        }
    }

    /**
     * Given an Array of 3 elements, where
     * - 1-st element is a `year`;
     * - 2-nd element is s `month`;
     * - 3-rd element is a `day of month`;
     * <p>
     * Return LocalDate built from these elements. If Array contains more than 3 elements - throw DateTimeException.
     */
    public LocalDate getDate(Integer[] dateParams) {
        if (dateParams.length != 3) {
            throw new DateTimeException("Invalid input parameter: " + dateParams);
        }
        return LocalDate.of(dateParams[0], dateParams[1], dateParams[2]);
    }

    /**
     * Given the time and the number of hours to add, return the changed time.
     */
    public LocalTime addHours(LocalTime localTime, Integer hoursToAdd) {
        return localTime.plusHours(hoursToAdd);
    }

    /**
     * Given the time and the number of minutes to add, return the changed time.
     */
    public LocalTime addMinutes(LocalTime localTime, Integer minutesToAdd) {
        return localTime.plusMinutes(minutesToAdd);
    }

    /**
     * Given the time and the number of seconds to add, return the changed time.
     */
    public LocalTime addSeconds(LocalTime localTime, Integer secondsToAdd) {
        return localTime.plusSeconds(secondsToAdd);
    }

    /**
     * Given the date and the number of weeks to add, return the changed date.
     */
    public LocalDate addWeeks(LocalDate localDate, Integer numberOfWeeks) {
        return localDate.plusWeeks(numberOfWeeks);
    }

    /**
     * Given a random `someDate` date, return one of the following Strings:
     * - "`someDate` is after `currentDate`"
     * if `someDate` is in the future relating to the `current date`;
     * - "`someDate` is before `currentDate`"
     * if `someDate` is in the past relating to the `current date`;
     * - "`someDate` is today"
     * if `someDate` is today;
     */
    public String beforeOrAfter(LocalDate someDate) {
        LocalDate currentDate = LocalDate.now();
        int diff = currentDate.compareTo(someDate);
        if (diff > 0) {
            return someDate + " is before " + currentDate;
        } else if (diff < 0) {
            return someDate + " is after " + currentDate;
        } else {
            return someDate + " is today";
        }
    }

    /**
     * Given a String representation of a date and some timezone,
     * return LocalDateTime in this timezone.
     */
    public LocalDateTime getDateInSpecificTimeZone(String dateInString, String zone) {
        ZoneId zoneId = ZoneId.of(zone);
        return LocalDateTime.ofInstant(ZonedDateTime.parse(dateInString).toInstant(), zoneId);
    }

    /**
     * Given some LocalDateTime, return an OffsetDateTime with the local time offset applied
     * (`+02:00` for Ukraine).
     * <p>
     * Example: we receive a LocalDateTime with a value `2019-09-06T13:17`.
     * We should return the OffsetDateTime with a value `2019-09-06T13:17+02:00`,
     * where `+02:00` is the offset for our local timezone.
     * <p>
     * OffsetDateTime is recommended to use for storing date values in a database.
     */
    public OffsetDateTime offsetDateTime(LocalDateTime localTime) {
        return localTime.atOffset(ZoneOffset.of("+02:00"));
    }

    /**
     * Given a String formatted as `yyyyMMdd`,
     * return LocalDate object built from this String.
     */
    public LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyyMMdd").withLocale(Locale.UK);
        return LocalDate.parse(date, formatter);
    }

    /**
     * Given a String formatted as `d MMM yyyy` (MMM - Sep, Oct, etc),
     * return LocalDate object built from this String.
     */
    public LocalDate customParseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("d MMM yyyy").withLocale(Locale.UK);
        return LocalDate.parse(date, formatter);
    }

    /**
     * Given some LocalDateTime, return a String formatted as
     * `day(2-digit) month(full name in English) year(4-digit) hours(24-hour format):minutes`.
     * <p>
     * Example: "01 January 2000 18:00".
     */
    public String formatDate(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter
                .ofPattern("dd MMMM yyyy HH:mm")
                .withLocale(Locale.UK));
    }
}
