package school;

import services.PublicHolidayService;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Course {
    private String name;
    private Integer eap;
    private Teacher teacher;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    public Course() {
    }

    public Course(ZonedDateTime startDate, ZonedDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Course(String name) {
        this.name = name;
        this.eap = eap;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getWorkingDays() {
        if (endDate.isAfter(startDate)) {

            final int startW = startDate.getDayOfWeek().getValue();
            final int endW = endDate.getDayOfWeek().getValue();

            try {

                final long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
                long result = days - 2*(days/7); //remove weekends

                if (days % 7 != 0) { //deal with the rest days
                    if (startW == 7) {
                        result -= 1;
                    } else if (endW == 7) {  //they can't both be Sunday, otherwise rest would be zero
                        result -= 1;
                    } else if (endW < startW) { //another weekend is included
                        result -= 2;
                    }
                }
                return result;

            } catch (Exception ex) {
                throw new IllegalArgumentException("wrong data");
            }

        } else {
            throw new IllegalArgumentException("something happened");
        }
    }

    public String getName() {
        return name;
    }

    public Integer getEap() {
        return eap;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public long getLength() {
        PublicHolidayService publicHolidayService = new PublicHolidayService();
        long workingDays = getWorkingDays() - publicHolidayService.getPublicHolidaysOnWorkdays(startDate, endDate);
        return workingDays;
    }
}