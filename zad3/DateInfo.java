package zad3;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateInfo {
public static void main(String[] args) {
    
        LocalDateTime CzasTeraz = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        ZoneId Zone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkTime = ZonedDateTime.now(Zone);

        LocalDate Date = LocalDate.now();
        DateRange OkresCzasu = getPreviousMonthRange(Date);

        System.out.println("Teraźniejsza data i czas: " + CzasTeraz.format(formatter));
        System.out.println("W Nowym Jorku teraz jest: " + newYorkTime.format(formatter));

        System.out.println("Początek miesiąca: " + OkresCzasu.from());
        System.out.println("Koniec miesiąca: " + OkresCzasu.to());
        System.out.println("Liczba dni obliczonych od \"from\" do \"to\": " + OkresCzasu.numberBetween());
    }

    public static DateRange getPreviousMonthRange(LocalDate date) {
        YearMonth poprzedniM = YearMonth.from(date).minusMonths(1);
        LocalDateTime start = poprzedniM.atDay(1).atStartOfDay();
        LocalDateTime stop = poprzedniM.atEndOfMonth().atTime(LocalTime.MAX);
        long dniPomiędzy = stop.toLocalDate().toEpochDay() - start.toLocalDate().toEpochDay() - 1;

        return new DateRange(start, stop, dniPomiędzy);
    }

    record DateRange(LocalDateTime from, LocalDateTime to, long numberBetween) {
    }
}
