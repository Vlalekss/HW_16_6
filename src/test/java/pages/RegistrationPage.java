package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;

    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;

    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();

        return this;

    }

    public RegistrationPage setUserEmail(String value) {
        $("#userEmail").setValue(value); // tode move to Selenide elements

        return this;

    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click(); // tode move to Selenide elements

        return this;

    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value); // tode move to Selenide elements

        return this;

    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;

    }

    public RegistrationPage setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;

    }

    public RegistrationPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;

    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;

    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;

    }

    public RegistrationPage submit() {
        $("#submit").click();

        return this;

    }

    public RegistrationPage setBirthDate(String day, String mouth, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, mouth, year);

        return this;

    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }


}
