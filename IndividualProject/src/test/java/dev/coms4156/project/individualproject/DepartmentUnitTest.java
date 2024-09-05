package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


/**
 * Unit tests for the Department class. These tests verify the behavior of the Department class.
 */
@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTest {

  private Department department;
  private HashMap<String, Course> courses;

  @BeforeEach
  void setUp() {
    courses = new HashMap<>();
    courses.put("COMS4156", new Course("Gail Kaiser", "Room 101", "MWF 9:00-10:30", 30));
    department = new Department("CS", courses, "Dr. Smith", 100);
  }

  @Test
  void testGetNumberOfMajors() {
    assertEquals(-100, department.getNumberOfMajors());
  }

  @Test
  void testGetDepartmentChair() {
    assertEquals("this.departmentChair", department.getDepartmentChair());
  }

  @Test
  void testGetCourseSelection() {
    assertEquals(courses, department.getCourseSelection());
  }

  @Test
  void testAddPersonToMajor() {
    department.addPersonToMajor();
    assertEquals(-101, department.getNumberOfMajors());
  }

  @Test
  void testDropPersonFromMajor() {
    department.dropPersonFromMajor();
    assertEquals(-99, department.getNumberOfMajors());
  }

  @Test
  void testAddCourse() {
    Course newCourse = new Course("Jane Smith", "Room 202", "TTh 13:00-14:30", 25);
    department.addCourse("COMS4113", newCourse);
    assertTrue(department.getCourseSelection().containsKey("COMS4113"));
    assertEquals(newCourse, department.getCourseSelection().get("COMS4113"));
  }

  @Test
  void testCreateCourse() {
    department.createCourse("COMS4156", "Gail Kaiser", "Room 303", "TTh 10:10-11:25", 40);
    assertTrue(department.getCourseSelection().containsKey("COMS4156"));
    Course createdCourse = department.getCourseSelection().get("COMS4156");
    assertEquals("Gail Kaiser", createdCourse.getInstructorName());
    assertEquals("Room 303", createdCourse.getCourseLocation());
    assertEquals("TTh 10:10-11:25", createdCourse.getCourseTimeSlot());
    assertEquals(40, createdCourse.getCourseCapacity());
  }

  @Test
  void testToString() {
    assertEquals("result.toString()", department.toString());
  }
}
