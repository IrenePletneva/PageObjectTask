package demoqa.test;

import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import demoqa.utils.TestsData;


public class RegistrationPageTest extends BaseTest {


    RegistrationPage registrationPage = new RegistrationPage();
    TestsData testData = new TestsData();

    @Test
    void fillingAllFieldsTest() {

        registrationPage.openPage()
                .removeFooter()
                .setFirstName(testData.randomFirstName)
                .setLastName(testData.randomLastName)
                .setUserEmail(testData.randomEmail)
                .setGender(testData.randomGender)
                .setUserNumber(testData.randomPhone)
                .setBirthDay(testData.randomMonth, testData.randomYear,testData.randomDay)
                .setSubjects(testData.randomSubjects)
                .setHobbies(testData.randomHobbies)
                .uploadPicture(testData.defaultImage)
                .setAddress(testData.randomAddress)
                .setState(testData.randomState)
                .setCity(testData.randomCity)
                .clickOnSubmitButton();

        registrationPage.checkOverResults("Student Name", testData.randomFirstName + " " + testData.randomLastName)
                .checkOverResults("Student Email", testData.randomEmail)
                .checkOverResults("Gender", testData.randomGender)
                .checkOverResults("Mobile", testData.randomPhone)
                .checkOverResults("Date of Birth", testData.randomDay + " " + testData.randomMonth + "," + testData.randomYear)
                .checkOverResults("Subjects", String.join(", ", testData.randomSubjects))
                .checkOverResults("Hobbies", String.join(", ", testData.randomHobbies))
                .checkOverResults("Picture", testData.defaultImage)
                .checkOverResults("Address", testData.randomAddress)
                .checkOverResults("State and City", testData.randomState + " " + testData.randomCity);
    }
}