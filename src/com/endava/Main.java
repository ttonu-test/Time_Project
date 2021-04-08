package com.endava;

import java.time.*;

public class Main {

    public static void main(String[] args) {
        //FIRST TASK
//        ZoneId zoneIdSydney = ZoneId.of("Australia/Sydney");
//        LocalDate dateSydney = LocalDate.now();
//        LocalTime timeSydney = LocalTime.of(11, 15, 0);
//        ZonedDateTime zonedDateSydney = ZonedDateTime.of(dateSydney, timeSydney, zoneIdSydney);

        ZonedDateTime zonedDateSydney = ZonedDateTime.of(LocalDate.now(), LocalTime.of(11, 15, 0), ZoneId.of("Australia/Sydney"));

//        ZoneId zoneIdLosAngeles = ZoneId.of("America/Los_Angeles");
//        LocalDate dateLA = LocalDate.now();
//        LocalTime timeLA = LocalTime.of(6, 0, 0);
//        ZonedDateTime zonedDateLA = ZonedDateTime.of(dateLA, timeLA, zoneIdLosAngeles);

        ZonedDateTime zonedDateLA = ZonedDateTime.of(LocalDate.now(), LocalTime.of(6, 0, 0), ZoneId.of("America/Los_Angeles"));

        OffsetDateTime departureTime = zonedDateSydney.toOffsetDateTime();
        OffsetDateTime arrivalTime = zonedDateLA.toOffsetDateTime();

        Duration duration = Duration.between(departureTime, arrivalTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();

//        Duration flightDuration = Duration.between(zonedDateSydney, zonedDateLA);
//                long hours = flightDuration.toHours();
//       long minutes = flightDuration.toMinutesPart();

        System.out.print("Duration of the flight from Sydney to Los Angeles is: ");
        System.out.printf("%d:%02d", hours, minutes);

        System.out.println("\n");

        //SECOND TASK

        StarWars releasedDay = new StarWars();
        //What day of the week was it released?
        DayOfWeek day = releasedDay.displayReleasedDay();
        System.out.println("Star Wars was released on " + day + ".");

        //how many times was it played in the first 2 years?
        int countTotalTimes = releasedDay.countTotalTimes();
        System.out.println("In the first 2 years, Star Wars was played " + countTotalTimes + " times.");

        //How man TOTAL minutes/hours/days of playtime it summed up in the 1st year?
        long min = releasedDay.calculateTotalRunningTimeInMinutes();
        long hour = releasedDay.calculateTotalRunningTimeInHours();
        long totalDays = releasedDay.calculateTotalRunningTimeInDays();
        System.out.println("Total minutes of playtime it summed up in the 1st year: " + min + ".");
        System.out.println("Total hours of playtime it summed up in the 1st year: " + hour + ".");
        System.out.println("Total days of playtime it summed up in the 1st year: " + totalDays + ".");
    }

}
