package demoqa.test;

import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPageTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationTest() {

        registrationPage.openPage()
                .removeFixedBanner()
                .removeFooter()
                .setFirstName("Test")
                .setLastName("Test")
                .setUserEmail("test@test.com")
                .setGender("Female")
                .setUserNumber("8980362893")
                .setBirthDay("January", "1990", "11")
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("img.jpg")
                .setAddress("Test address")
                .setState("NCR")
                .setCity("Gurgaon")
                .clickOnSubmitButton();

        registrationPage.checkOverResults("Student Name", "Test Test")
                .checkOverResults("Student Email", "test@test.com")
                .checkOverResults("Gender", "Female")
                .checkOverResults("Mobile", "8980362893")
                .checkOverResults("Date of Birth", "11 January,1990")
                .checkOverResults("Subjects", "Maths")
                .checkOverResults("Hobbies", "Sports")
                .checkOverResults("Picture", "img.jpg")
                .checkOverResults("Address", "Test address")
                .checkOverResults("State and City", "NCR Gurgaon");
    }
}