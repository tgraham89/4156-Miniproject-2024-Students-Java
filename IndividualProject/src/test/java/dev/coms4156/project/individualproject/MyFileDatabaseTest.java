package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * Unit tests for the Department class.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MyFileDatabaseTest {

  @MockBean
  private MyFileDatabase myFileDatabase;

  @BeforeEach
  void setup() {
    IndividualProjectApplication application = new IndividualProjectApplication();
    application.resetDataFile();
    myFileDatabase = IndividualProjectApplication.myFileDatabase;
  }

  @Test
  void toStringTest() {
    String expectedResult = "For the ELEN department: \n" + "ELEN 3082: \n"
        + "Instructor: Kenneth Shepard; Location: 1205 MUDD; Time: 4:10-6:40\n" + "ELEN 1201: \n"
        + "Instructor: David G Vallancourt; Location: 301 PUP; Time: 4:10-5:25\n" + "ELEN 3401: \n"
        + "Instructor: Keren Bergman; Location: 829 MUDD; Time: 2:40-3:55\n" + "ELEN 4510: \n"
        + "Instructor: Mohamed Kamaludeen; Location: 903 SSW; Time: 7:00-9:30\n" + "ELEN 3331: \n"
        + "Instructor: David G Vallancourt; Location: 203 MATH; Time: 11:40-12:55\n"
        + "ELEN 4830: \n"
        + "Instructor: Christine P Hendon; Location: 633 MUDD; Time: 10:10-12:40\n"
        + "ELEN 3701: \n" + "Instructor: Irving Kalet; Location: 333 URIS; Time: 2:40-3:55\n"
        + "ELEN 4702: \n" + "Instructor: Alexei Ashikhmin; Location: 332 URIS; Time: 7:00-9:30\n"
        + "For the CHEM department: \n" + "CHEM 1403: \n"
        + "Instructor: Ruben M Savizky; Location: 309 HAV; Time: 6:10-7:25\n" + "CHEM 3080: \n"
        + "Instructor: Milan Delor; Location: 209 HAV; Time: 10:10-11:25\n" + "CHEM 1500: \n"
        + "Instructor: Joseph C Ulichny; Location: 302 HAV; Time: 6:10-9:50\n" + "CHEM 2444: \n"
        + "Instructor: Christopher Eckdahl; Location: 309 HAV; Time: 11:40-12:55\n"
        + "CHEM 4102: \n" + "Instructor: Dalibor Sames; Location: 320 HAV; Time: 10:10-11:25\n"
        + "CHEM 2045: \n" + "Instructor: Luis M Campos; Location: 209 HAV; Time: 1:10-2:25\n"
        + "CHEM 2494: \n" + "Instructor: Talha Siddiqui; Location: 202 HAV; Time: 1:10-5:00\n"
        + "CHEM 4071: \n" + "Instructor: Jonathan S Owen; Location: 320 HAV; Time: 8:40-9:55\n"
        + "For the PHYS department: \n" + "PHYS 4040: \n"
        + "Instructor: James C Hill; Location: 214 PUP; Time: 4:10-5:25\n" + "PHYS 1602: \n"
        + "Instructor: Kerstin M Perez; Location: 428 PUP; Time: 10:10-11:25\n" + "PHYS 3008: \n"
        + "Instructor: William A Zajc; Location: 329 PUP; Time: 10:10-11:25\n" + "PHYS 1201: \n"
        + "Instructor: Eric Raymer; Location: 428 PUP; Time: 2:40-3:55\n" + "PHYS 4003: \n"
        + "Instructor: Frederik Denef; Location: 214 PUP; Time: 4:10-5:25\n" + "PHYS 1001: \n"
        + "Instructor: Szabolcs Marka; Location: 301 PUP; Time: 2:40-3:55\n" + "PHYS 4018: \n"
        + "Instructor: James W McIver; Location: 307 PUP; Time: 2:40-3:55\n" + "PHYS 2802: \n"
        + "Instructor: Yury Levin; Location: 329 PUP; Time: 10:10-12:00\n"
        + "For the PSYC department: \n" + "PSYC 4493: \n"
        + "Instructor: Jennifer Blaze; Location: 200 SCH; Time: 2:10-4:00\n" + "PSYC 1610: \n"
        + "Instructor: Christopher Baldassano; Location: 200 SCH; Time: 10:10-11:25\n"
        + "PSYC 2235: \n"
        + "Instructor: Katherine T Fox-Glassman; Location: 501 SCH; Time: 11:40-12:55\n"
        + "PSYC 2620: \n" + "Instructor: Jeffrey M Cohen; Location: 303 URIS; Time: 1:10-3:40\n"
        + "PSYC 3445: \n" + "Instructor: Mariam Aly; Location: 405 SCH; Time: 2:10-4:00\n"
        + "PSYC 1001: \n" + "Instructor: Patricia G Lindemann; Location: 501 SCH; Time: 1:10-2:25\n"
        + "PSYC 3212: \n" + "Instructor: Mayron Piccolo; Location: 200 SCH; Time: 2:10-4:00\n"
        + "PSYC 4236: \n" + "Instructor: Trenton Jerde; Location: 405 SCH; Time: 6:10-8:00\n"
        + "For the COMS department: \n" + "COMS 3827: \n"
        + "Instructor: Daniel Rubenstein; Location: 207 Math; Time: 10:10-11:25\n" + "COMS 1004: \n"
        + "Instructor: Adam Cannon; Location: 417 IAB; Time: 11:40-12:55\n" + "COMS 3203: \n"
        + "Instructor: Ansaf Salleb-Aouissi; Location: 301 URIS; Time: 10:10-11:25\n"
        + "COMS 4156: \n" + "Instructor: Gail Kaiser; Location: 501 NWC; Time: 10:10-11:25\n"
        + "COMS 3157: \n" + "Instructor: Jae Lee; Location: 417 IAB; Time: 4:10-5:25\n"
        + "COMS 3134: \n" + "Instructor: Brian Borowski; Location: 301 URIS; Time: 4:10-5:25\n"
        + "COMS 3251: \n" + "Instructor: Tony Dear; Location: 402 CHANDLER; Time: 1:10-3:40\n"
        + "COMS 3261: \n" + "Instructor: Josh Alman; Location: 417 IAB; Time: 2:40-3:55\n"
        + "For the ECON department: \n" + "ECON 1105: \n"
        + "Instructor: Waseem Noor; Location: 309 HAV; Time: 2:40-3:55\n" + "ECON 2257: \n"
        + "Instructor: Tamrat Gashaw; Location: 428 PUP; Time: 10:10-11:25\n" + "ECON 3412: \n"
        + "Instructor: Thomas Piskula; Location: 702 HAM; Time: 11:40-12:55\n" + "ECON 3213: \n"
        + "Instructor: Miles Leahey; Location: 702 HAM; Time: 4:10-5:25\n" + "ECON 3211: \n"
        + "Instructor: Murat Yilmaz; Location: 310 FAY; Time: 4:10-5:25\n" + "ECON 4840: \n"
        + "Instructor: Mark Dean; Location: 142 URIS; Time: 2:40-3:55\n" + "ECON 4710: \n"
        + "Instructor: Matthieu Gomez; Location: 517 HAM; Time: 8:40-9:55\n" + "ECON 4415: \n"
        + "Instructor: Evan D Sadler; Location: 309 HAV; Time: 10:10-11:25\n"
        + "For the IEOR department: \n" + "IEOR 3404: \n"
        + "Instructor: Christopher J Dolan; Location: 303 MUDD; Time: 10:10-11:25\n"
        + "IEOR 2500: \n" + "Instructor: Uday Menon; Location: 627 MUDD; Time: 11:40-12:55\n"
        + "IEOR 4540: \n"
        + "Instructor: Krzysztof M Choromanski; Location: 633 MUDD; Time: 7:10-9:40\n"
        + "IEOR 4102: \n" + "Instructor: Antonius B Dieker; Location: 209 HAM; Time: 10:10-11:25\n"
        + "IEOR 4511: \n" + "Instructor: Michael Robbins; Location: 633 MUDD; Time: 9:00-11:30\n"
        + "IEOR 4106: \n" + "Instructor: Kaizheng Wang; Location: 501 NWC; Time: 10:10-11:25\n"
        + "IEOR 4405: \n" + "Instructor: Yuri Faenza; Location: 517 HAV; Time: 11:40-12:55\n"
        + "IEOR 3658: \n" + "Instructor: Daniel Lacker; Location: 310 FAY; Time: 10:10-11:25\n";
    assertEquals(expectedResult, myFileDatabase.toString());
  }
}
