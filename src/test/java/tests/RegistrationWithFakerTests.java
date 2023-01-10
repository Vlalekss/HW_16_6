package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends TestBase {


    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker();

        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = "Other";
        String mobile = faker.phoneNumber().subscriberNumber(10);
        String dayBirth = "30";
        String monthBirth = "July";
        String yearBirth = "2008";
        String subjects = "Math";
        String hobbies = "Sports";
        String picture = "1.png";
        String currentAddress = faker.address().streetAddress();
        String state = "NCR";
        String City = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhone(mobile)
                .setBirthDate(dayBirth, monthBirth, yearBirth)
                .setSubject(subjects)
                .setHobbies(hobbies)
                .setPicture("img/"+picture)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(City)
                .submit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", userName+" "+lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", mobile)
                .verifyResults("Date of Birth", dayBirth+" "+monthBirth+","+yearBirth)
                .verifyResults("Subjects", subjects)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", picture)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state+" "+City);

    }

}

