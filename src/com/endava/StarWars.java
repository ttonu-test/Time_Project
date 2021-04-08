package com.endava;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class StarWars {
    private final LocalDate releasedDate;
    private final Duration playtime;

    public StarWars() {
        this.releasedDate = LocalDate.of(1977, 5, 25);
        this.playtime = Duration.ofMinutes(120);
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public Duration getPlaytime() {
        return playtime;
    }

    public DayOfWeek displayReleasedDay() {
        DayOfWeek day = getReleasedDate().getDayOfWeek();
        return day;
    }

    public int countTotalTimes() {
        LocalDate endMoviePlayed = getReleasedDate().plusYears(2);
        LocalDate firstSaturdayPlayed = getReleasedDate().with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        LocalDate firstSundayPlayed = getReleasedDate().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        int count = 1;

        while (firstSaturdayPlayed.isBefore(endMoviePlayed) || firstSundayPlayed.isBefore(endMoviePlayed)) {
            firstSaturdayPlayed = firstSaturdayPlayed.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
            firstSundayPlayed = firstSundayPlayed.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
            count++;
            count++;
        }
        return count;
    }

    public int countTotalTimesInFirstYear() {
        LocalDate endMoviePlayed = getReleasedDate().plusYears(1);
        LocalDate firstSaturdayPlayed = getReleasedDate().with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        LocalDate firstSundayPlayed = getReleasedDate().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        int count2 = 1;

        while (firstSaturdayPlayed.isBefore(endMoviePlayed) || firstSundayPlayed.isBefore(endMoviePlayed)) {
            firstSaturdayPlayed = firstSaturdayPlayed.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
            firstSundayPlayed = firstSundayPlayed.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
            count2++;
            count2++;
        }
        return count2;
    }

    public long calculateTotalRunningTimeInMinutes() {
        int totalDays = countTotalTimesInFirstYear();
        long totalPlayedMinutes = getPlaytime().multipliedBy(totalDays).toMinutes();
        return totalPlayedMinutes;
    }

    public long calculateTotalRunningTimeInHours() {
        long totalPlayedInHours = Duration.of(calculateTotalRunningTimeInMinutes(), ChronoUnit.MINUTES).toHours();
        return totalPlayedInHours;
    }

    public long calculateTotalRunningTimeInDays() {
        long totalPlayedInDays = Duration.of(calculateTotalRunningTimeInMinutes(), ChronoUnit.MINUTES).toDays();
        return totalPlayedInDays;
    }
}
