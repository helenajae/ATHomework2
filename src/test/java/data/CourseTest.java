package data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import school.Course;
import services.PublicHolidayService;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.ZonedDateTime;
//import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.when;

public class CourseTest {
    ZonedDateTime startDate = ZonedDateTime.parse("2020-05-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime endDate = ZonedDateTime.parse("2020-04-01T00:00:00.000+00:00[UTC]");
    //ZonedDateTime dateOfBirth = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");

    @Mock
    private PublicHolidayService publicHolidayService;

    @InjectMocks
    Course course = new Course(startDate, endDate);

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLength(){ //unit test
        ZonedDateTime startDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        ZonedDateTime endDate = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");
        Long expectedResult = 23L;
        Course course = new Course(startDate, endDate);
        //when
        Long result = course.getLength();
        //then
        assertEquals(expectedResult, result);
    }

    @Test
    public void getDaysInputWrongOrder(){ //negatiivne test
        ZonedDateTime startDate = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");
        ZonedDateTime endDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        Course course = new Course(startDate, endDate);
        when(publicHolidayService.getPublicHolidaysOnWorkdays(startDate,endDate)).thenReturn(1);
        //when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> course.getWorkingDays());
        //then
        assertEquals("something happened", exception.getMessage());
    }

    @Test(expected = NullPointerException.class)
    public void getLenghtNoData() {
        Course course = new Course();
        Long result = course.getLength();
    }
}