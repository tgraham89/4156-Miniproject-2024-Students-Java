package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Unit tests for the Course class.
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {
  private Course testCourse;

  @BeforeEach
  public void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
  }


  @Test
  void toStringTest() {
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  void getEnrolledStudentCountTest() {
    assertEquals(0, testCourse.getEnrolledStudentCount());
  }

  @Test
  void enrollStudentTest() {
    testCourse.enrollStudent();
    assertEquals(1, testCourse.getEnrolledStudentCount());
  }

  @Test
  void enrollStudentCourseFullTest() {
    Course otherTestCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 0);
    assertFalse(otherTestCourse.enrollStudent());
  }

  @Test
  void dropStudentTest() {
    testCourse.enrollStudent();
    testCourse.dropStudent();
    assertEquals(0, testCourse.getEnrolledStudentCount());
  }

  @Test
  void dropStudentNoEnrollmentTest() {
    assertFalse(testCourse.dropStudent());
  }

  @Test
  void getCourseLocationTest() {
    assertEquals("417 IAB", testCourse.getCourseLocation());
  }

  @Test
  void getInstructorNameTest() {
    assertEquals("Griffin Newbold", testCourse.getInstructorName());
  }

  @Test
  void getCourseTimeSlotTest() {
    assertEquals("11:40-12:55", testCourse.getCourseTimeSlot());
  }

  @Test
  void getCourseCapacityTest() {
    assertEquals(250, testCourse.getCourseCapacity());
  }

  @Test
  void reassignInstructorTest() {
    testCourse.reassignInstructor("Gail Kaiser");
    assertEquals("Gail Kaiser", testCourse.getInstructorName());
  }

  @Test
  void reassignLocationTest() {
    testCourse.reassignLocation("Room 101");
    assertEquals("Room 101", testCourse.getCourseLocation());
  }

  @Test
  void reassignTimeTest() {
    testCourse.reassignTime("10:10-11:25");
    assertEquals("10:10-11:25", testCourse.getCourseTimeSlot());
  }

  @Test
  void setEnrolledStudentCountTest() {
    testCourse.setEnrolledStudentCount(100);
    assertEquals(100, testCourse.getEnrolledStudentCount());
  }

  @Test
  void isCourseFullNotFullTest() {
    assertFalse(testCourse.isCourseFull());
  }

  @Test
  void isCourseFullIsFullTest() {
    testCourse.setEnrolledStudentCount(251);
    assertTrue(testCourse.isCourseFull());
  }
}

