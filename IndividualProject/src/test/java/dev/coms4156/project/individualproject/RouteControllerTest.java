package dev.coms4156.project.individualproject;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Tests for the RouteControoller class.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RouteControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MyFileDatabase myFileDatabase;

  @InjectMocks
  private RouteController routeController;

  @BeforeEach
  void setup() {
    IndividualProjectApplication application = new IndividualProjectApplication();
    application.resetDataFile();
    myFileDatabase = IndividualProjectApplication.myFileDatabase;
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(routeController).build();
  }

  @Test
  void indexTest() throws Exception {
    mockMvc.perform(get("/")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Welcome")));
  }

  @Test
  void retrieveDepartmentNotFoundTest() throws Exception {
    mockMvc.perform(get("/retrieveDept").param("deptCode", "BLAH")).andExpect(status().isNotFound())
        .andExpect(content().string("Department Not Found"));
  }

  @Test
  void retrieveDepartmentFoundTest() throws Exception {
    Map<String, Department> mapping = myFileDatabase.getDepartmentMapping();
    String comsMapping = mapping.get("COMS").toString();

    mockMvc.perform(get("/retrieveDept").param("deptCode", "COMS")).andExpect(status().isOk())
        .andExpect(content().string(comsMapping));
  }

  @Test
  void retrieveCourseNotFoundTest() throws Exception {
    mockMvc.perform(get("/retrieveCourse").param("deptCode", "COMS").param("courseCode", "9999"))
        .andExpect(status().isNotFound()).andExpect(content().string("Course Not Found"));
  }

  @Test
  void retrieveCourseFoundTest() throws Exception {
    mockMvc.perform(get("/retrieveCourse").param("deptCode", "COMS").param("courseCode", "4156"))
        .andExpect(status().isOk()).andExpect(
            content().string("\nInstructor: Gail Kaiser; Location: 501 NWC; Time: 10:10-11:25"));
  }

  @Test
  void isCourseFullTest() throws Exception {
    mockMvc.perform(get("/isCourseFull").param("deptCode", "COMS").param("courseCode", "4156"))
        .andExpect(status().isOk()).andExpect(content().string("false"));
  }

  @Test
  void getMajorCtFromDeptTest() throws Exception {
    mockMvc.perform(get("/getMajorCountFromDept").param("deptCode", "COMS"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("There are: 2700 majors in the department")));
  }

  @Test
  void identifyDeptChairTest() throws Exception {
    mockMvc.perform(get("/idDeptChair").param("deptCode", "COMS")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Luca Carloni is the department chair.")));
  }

  @Test
  void findCourseLocationTest() throws Exception {
    mockMvc
        .perform(get("/findCourseLocation").param("deptCode", "COMS").param("courseCode", "4156"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("501 NWC is where the course is located.")));
  }

  @Test
  void findCourseInstructorTest() throws Exception {
    mockMvc
        .perform(get("/findCourseInstructor").param("deptCode", "COMS").param("courseCode", "3251"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Tony Dear is the instructor for the course.")));
  }

  @Test
  void addMajorToDeptTest() throws Exception {
    mockMvc.perform(patch("/addMajorToDept").param("deptCode", "COMS")).andExpect(status().isOk())
        .andExpect(content().string("Attribute was updated successfully"));
  }

  @Test
  void removeMajorFromDeptTest() throws Exception {
    mockMvc.perform(patch("/removeMajorFromDept").param("deptCode", "COMS"))
        .andExpect(status().isOk())
        .andExpect(content().string("Attribute was updated or is at minimum"));
  }

  @Test
  void dropStudentTest() throws Exception {
    mockMvc
        .perform(
            patch("/dropStudentFromCourse").param("deptCode", "COMS").param("courseCode", "4156"))
        .andExpect(status().isOk()).andExpect(content().string("Student has been dropped."));
  }

  @Test
  void setEnrollmentCountTest() throws Exception {
    mockMvc
        .perform(patch("/setEnrollmentCount").param("deptCode", "COMS").param("courseCode", "4156")
            .param("count", "200"))
        .andExpect(status().isOk())
        .andExpect(content().string("Attributed was updated successfully."));
  }

  @Test
  void findCourseTimeTest() throws Exception {
    mockMvc.perform(get("/findCourseTime").param("deptCode", "COMS").param("courseCode", "4156"))
        .andExpect(status().isOk()).andExpect(content().string("The course meets at: 10:10-11:25"));
  }

  @Test
  void changeCourseTimeTest() throws Exception {
    mockMvc
        .perform(patch("/changeCourseTime").param("deptCode", "COMS").param("courseCode", "4156")
            .param("time", "2:40-3:55"))
        .andExpect(status().isOk())
        .andExpect(content().string("Attributed was updated successfully."));
  }

  @Test
  void changeCourseTeacherTest() throws Exception {
    mockMvc
        .perform(patch("/changeCourseTeacher").param("deptCode", "COMS").param("courseCode", "4156")
            .param("teacher", "Jae Lee"))
        .andExpect(status().isOk())
        .andExpect(content().string("Attributed was updated successfully."));
  }

  @Test
  void testChangeCourseLocation() throws Exception {
    mockMvc
        .perform(patch("/changeCourseLocation").param("deptCode", "COMS")
            .param("courseCode", "4156").param("location", "402 CHANDLER"))
        .andExpect(status().isOk())
        .andExpect(content().string("Attributed was updated successfully."));
  }

  @Test
  void testRetrieveCoursesOneCourse() throws Exception {
    mockMvc.perform(get("/retrieveCourses").param("courseCode", "4156")).andExpect(status().isOk())
        .andExpect(content()
            .string("Found courses matching course code 4156:\n" + "In the COMS department: \n"
                + "Instructor: Gail Kaiser; Location: 501 NWC; Time: 10:10-11:25"));
  }

  @Test
  void testRetrieveCoursesManyCourses() throws Exception {
    Map<String, Department> mapping = myFileDatabase.getDepartmentMapping();

    Department department = mapping.get("COMS");
    Course newCourse = new Course("Tony Dear", "402 CHANDLER", "1:10-3:40", 125);
    department.addCourse("4567", newCourse);
    mapping.put("COMS", department);

    department = mapping.get("PHYS");
    newCourse = new Course("Yury Levin", "329 PUP", "10:10-12:00", 60);
    department.addCourse("4567", newCourse);
    mapping.put("PHYS", department);

    department = mapping.get("ECON");
    newCourse = new Course("Matthieu Gomez", "517 HAM", "8:40-9:55", 86);
    department.addCourse("4567", newCourse);
    mapping.put("ECON", department);

    myFileDatabase.setMapping(mapping);

    mockMvc.perform(get("/retrieveCourses").param("courseCode", "4567")).andExpect(status().isOk())
        .andExpect(content()
            .string("Found courses matching course code 4567:" + "\nIn the PHYS department: "
                + "\nInstructor: Yury Levin; Location: 329 PUP; Time: 10:10-12:00"
                + "\nIn the COMS department: "
                + "\nInstructor: Tony Dear; Location: 402 CHANDLER; Time: 1:10-3:40"
                + "\nIn the ECON department: "
                + "\nInstructor: Matthieu Gomez; Location: 517 HAM; Time: 8:40-9:55"));
  }

  @Test
  void testRetrieveCoursesNoCourses() throws Exception {
    mockMvc.perform(get("/retrieveCourses").param("courseCode", "0000"))
        .andExpect(status().isNotFound()).andExpect(content().string("No courses were found"));
  }
}
