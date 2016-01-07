package com.claridy.khub.admin.core.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.google.common.collect.Lists;

import io.lamma.Date;
import io.lamma.Dates;
import io.lamma.DayOfMonths;
import rx.Observable;

public class DateUtils {

    public static final ZoneId TIME_ZONE = ZoneId.of("Asia/Taipei");

    public static LocalDateTime now() {
        return LocalDateTime.now(TIME_ZONE);
    }

    public static LocalDateTime jdk8Date2LocalDateTime(java.util.Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), DateUtils.TIME_ZONE);
    }

    public static java.util.Date localDateTime2JDK8Date(LocalDateTime localDateTime) {
        return java.util.Date.from(localDateTime.atZone(DateUtils.TIME_ZONE).toInstant());
    }

    public static Date localDaye2LammaDate(LocalDate localDate) {
        return Date.apply(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }

    public static LocalDate LammaDate2LocalDate(Date date) {
        return LocalDate.of(date.yyyy(), date.mm(), date.dd());
    }

    public static Observable<LocalDate> getNthWeekDayWithinPeriod(LocalDate periodStart, LocalDate periodEnd,
            List<DayOfWeek> nthWeekDay) {
        return Observable.from(nthWeekDay).map(it -> it.getValue()).map(io.lamma.DayOfWeek::of)
                .map(Dates.from(DateUtils.localDaye2LammaDate(periodStart)).to(DateUtils.localDaye2LammaDate(periodEnd))
                        .byWeeks(1)::on)
                .map(it -> it.build()).flatMap(Observable::from).map(DateUtils::LammaDate2LocalDate).toSortedList()
                .flatMap(Observable::from);
    }

    public static Observable<LocalDate> getNthWeekDayWithinPeriodAfterToday(LocalDate periodStart, LocalDate periodEnd,
            List<DayOfWeek> nthWeekDay) {
        return getNthWeekDayWithinPeriodAfterDate(periodStart, periodEnd, nthWeekDay,
                LocalDate.now(DateUtils.TIME_ZONE));
    }

    public static Observable<LocalDate> getNthWeekDayWithinPeriodAfterDate(LocalDate periodStart, LocalDate periodEnd,
            List<DayOfWeek> nthWeekDay, LocalDate date) {
        return getNthWeekDayWithinPeriod(periodStart, periodEnd, nthWeekDay).filter(it -> !it.isBefore(date));
    }

    public static Observable<LocalDate> getNthMonthDayWithinPeriod(LocalDate periodStart, LocalDate periodEnd,
            List<Integer> nthMonthDay) {
        return Observable.from(nthMonthDay).map(DayOfMonths::nthDay)
                .map(Dates.from(DateUtils.localDaye2LammaDate(periodStart)).to(DateUtils.localDaye2LammaDate(periodEnd))
                        .byMonths(1)::on)
                .map(it -> it.build()).flatMap(Observable::from).map(DateUtils::LammaDate2LocalDate).toSortedList()
                .flatMap(Observable::from).distinct();
    }

    public static Observable<LocalDate> getNthMonthDayWithinPeriodAfterToday(LocalDate periodStart, LocalDate periodEnd,
            List<Integer> nthMonthDay) {
        return getNthMonthDayWithinPeriodAfterDate(periodStart, periodEnd, nthMonthDay,
                LocalDate.now(DateUtils.TIME_ZONE));
    }

    public static Observable<LocalDate> getNthMonthDayWithinPeriodAfterDate(LocalDate periodStart, LocalDate periodEnd,
            List<Integer> nthMonthDay, LocalDate date) {
        return getNthMonthDayWithinPeriod(periodStart, periodEnd, nthMonthDay).filter(it -> !it.isBefore(date));
    }

    public static void main(String[] argv) {
        getNthWeekDayWithinPeriodAfterToday(LocalDate.of(2015, 10, 16), LocalDate.of(2015, 11, 1),
                Lists.newArrayList(DayOfWeek.SUNDAY, DayOfWeek.FRIDAY)).toBlocking().forEach(System.out::println);

        System.out.println("----");
        getNthMonthDayWithinPeriod(LocalDate.of(2015, 10, 1), LocalDate.of(2015, 11, 1),
                Lists.newArrayList(1, 2, 3, 10, 31, 20)).toBlocking().forEach(System.out::println);
    }
}