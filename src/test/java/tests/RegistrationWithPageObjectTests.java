package tests;

import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectTests extends TestBase {


    @Test
    void successfulRegistrationTest() {
        String userName = "Vlad";
        String lastName = "Aleksev";
        String Email = "vlad@aleksev.com";
        String gender = "Other";
        String Mobile = "1234567890";
        String dayBirth = "30";
        String monthBirth = "July";
        String yearBirth = "2008";
        String Subjects = "Math";
        String Hobbies = "Sports";
        String Picture = "img/1.png";
        String CurrentAddress = "Some address 1";
        String State = "NCR";
        String City = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
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
                .setSity("Delhi")
                .submit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student name", userName + "Aleksev")
                .verifyResults("Student email", "vlad@aleksev.com")
                .verifyResults("Gender", "Other")
                .verifyResults("Mobile", "1234567890")
                .verifyResults("Date of Birth", "30 July, 2008")
                .verifyResults("Subjects", "Math")
                .verifyResults("Hobbies", "Sports")
                .verifyResults("Pictrure", "1.png")
                .verifyResults("Address", "Some address 1")
                .verifyResults("State and City", "NCR Delhi");

    }

}

