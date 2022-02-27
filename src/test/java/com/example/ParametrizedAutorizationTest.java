package com.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedAutorizationTest {

    @BeforeEach
    void precondition() {
        Configuration.browserSize = "1920x1080";
        open("https://ya.ru");
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @CsvSource(value = {
            "test27022022| S8s9x0op | - Первые тестовые данные.",
            "testvtoroi27022022| S7sK8!sA | - бхъВторые тестовые данные."
    },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Проверка авторизации в почте Яндекс по логину и паролю: {2}")
    void autorizationTest(String login, String password, String descriptionTest) throws InterruptedException {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        $(byText("Войти в почту")).click();
        $("[data-lego='react']").sibling(0).click();
        $("#passp-field-login").setValue(login);
        $("[type='submit']").click();
        $("#passp-field-passwd").setValue(password);
        $("[type='submit']").click();
        Thread.sleep(1000);
        $("[type='button']").click();
        $(".mail-NestedList-Item-Name").shouldHave(Condition.text("Входящие")).shouldBe(Condition.visible);
    }
}
