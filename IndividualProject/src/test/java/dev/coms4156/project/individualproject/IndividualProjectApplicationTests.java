package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
class IndividualProjectApplicationTests {

  private IndividualProjectApplication application;

  @BeforeEach
  void setUp() {
    application = new IndividualProjectApplication();
  }

  @Test
  void testOverrideDatabase() {
    MyFileDatabase testDatabase = new MyFileDatabase(2, "test.txt");
    IndividualProjectApplication.overrideDatabase(testDatabase);
    assertSame(testDatabase, IndividualProjectApplication.myFileDatabase);
    assertFalse(
        (boolean) ReflectionTestUtils.getField(IndividualProjectApplication.class, "saveData"));
  }

  @Test
  void testResetDataFile() {
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

  @Test
  void testOnTermination() {
    MyFileDatabase mockDatabase = new MyFileDatabase(0, "test.txt") {
      @Override
      public void saveContentsToFile() {
        // Mock implementation to verify call
      }
    };
    IndividualProjectApplication.myFileDatabase = mockDatabase;
    ReflectionTestUtils.setField(IndividualProjectApplication.class, "saveData", true);

    application.onTermination();

    // Verify that saveContentsToFile was called (you might need a mocking framework for more robust
    // verification)
  }
}
