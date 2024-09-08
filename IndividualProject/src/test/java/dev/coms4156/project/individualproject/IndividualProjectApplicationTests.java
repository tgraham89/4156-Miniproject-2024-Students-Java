package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests for the IndividualProjectApplication class.
 */
@SpringBootTest
class IndividualProjectApplicationTests {

  private IndividualProjectApplication application;

  @BeforeEach
  void setUp() {
    application = new IndividualProjectApplication();
  }

  @Test
  void overrideDatabaseTest() {
    MyFileDatabase testDatabase = new MyFileDatabase(2, "test.txt");
    IndividualProjectApplication.overrideDatabase(testDatabase);
    assertSame(testDatabase, IndividualProjectApplication.myFileDatabase);
  }

  @Test
  void resetDataFileTest() {
    application.resetDataFile();
    MyFileDatabase database = IndividualProjectApplication.myFileDatabase;
    assertNotNull(database);

    // Check if departments are created
    assertNotNull(database.getDepartmentMapping().get("COMS"));
    assertNotNull(database.getDepartmentMapping().get("ECON"));
    assertNotNull(database.getDepartmentMapping().get("IEOR"));
    assertNotNull(database.getDepartmentMapping().get("CHEM"));
    assertNotNull(database.getDepartmentMapping().get("PHYS"));
    assertNotNull(database.getDepartmentMapping().get("ELEN"));
    assertNotNull(database.getDepartmentMapping().get("PSYC"));

    // Check a few specific courses
    Department coms = database.getDepartmentMapping().get("COMS");
    assertNotNull(coms.getCourseSelection().get("1004"));
    assertEquals("Adam Cannon", coms.getCourseSelection().get("1004").getInstructorName());
    assertEquals(249, coms.getCourseSelection().get("1004").getEnrolledStudentCount());

    Department econ = database.getDepartmentMapping().get("ECON");
    assertNotNull(econ.getCourseSelection().get("1105"));
    assertEquals("Waseem Noor", econ.getCourseSelection().get("1105").getInstructorName());
    assertEquals(187, econ.getCourseSelection().get("1105").getEnrolledStudentCount());
  }
}
