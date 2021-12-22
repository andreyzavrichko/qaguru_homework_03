package ru.zavrichko;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SearchSoftAssertionsTest {
    @Test
    void shouldFindSelenideRepositoryInGithub(){
        // Открываем страницу Selenide в Github
        open("https://github.com/");
        // Вводим в поле поиска selenide и нажимаем Enter
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        // Нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        // Проверяем, что в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
        // Переходим в раздел Wiki проекта
        $("#wiki-tab").click();
        // Проверяем, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body .markdown-body").shouldHave(text("Soft Assertions"));
        // Открываем страницу SoftAssertions,
        $x("(//a[@href='/selenide/selenide/wiki/SoftAssertions'])[2]").click();
        // Проверяем, что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
