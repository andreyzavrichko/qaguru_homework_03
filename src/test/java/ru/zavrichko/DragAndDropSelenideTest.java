package ru.zavrichko;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropSelenideTest {
    @Test
    void dragAndDropSelenideTest(){
        // Открываем страницу с drag and drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Проверяем что первый элемент div со значением A
        $$("#columns > div").first().shouldHave(text("A"));
        // Проверяем что второй элемент div со значением B
        $$("#columns > div").get(1).shouldHave(text("B"));
        // Находим первый элемент и перемещаем на второй
        $("#column-a").dragAndDropTo($("#column-b"));
        // Проверяем что элемент переместился и теперь на первом месте значение B
        $$("#columns > div").first().shouldHave(text("B"));
    }
}
