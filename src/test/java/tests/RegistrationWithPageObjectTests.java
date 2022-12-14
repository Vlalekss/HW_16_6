package tests;

import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectTests extends TestBase {


    @Test
    void successfulRegistrationTest() {
        String userName = "Vlad";
        String lastName = "Aleksev";
        String email = "vlad@aleksev.com";
        String gender = "Other";
        String mobile = "1234567890";
        String dayBirth = "30";
        String monthBirth = "July";
        String yearBirth = "2008";
        String subjects = "Math";
        String hobbies = "Sports";
        String picture = "img/1.png";
        String currentAddress = "Some address 1";
        String state = "NCR";
        String City = "Delhi";

        registrationPage.openPage()
                .setFirstName("Vlad")
                .setLastName("Aleksev")
                .setUserEmail("vlad@aleksev.com")
                .setGender("Other")
                .setPhone("1234567890")
                .setBirthDate("30", "July", "2008")
                .setSubject("Math")
                .setHobbies("Sports")
                .setPicture("img/1.png")
                .setAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .submit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", "Vlad Aleksev")
                .verifyResults("Student Email", "vlad@aleksev.com")
                .verifyResults("Gender", "Other")
                .verifyResults("Mobile", "1234567890")
                .verifyResults("Date of Birth", "30 July,2008")
                .verifyResults("Subjects", "Math")
                .verifyResults("Hobbies", "Sports")
                .verifyResults("Picture", "1.png")
                .verifyResults("Address", "Some address 1")
                .verifyResults("State and City", "NCR Delhi");

    }

}

