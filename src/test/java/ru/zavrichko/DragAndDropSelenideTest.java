package ru.zavrichko;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropSelenideTest {
    @Test
    void dragAndDropSelenideTest(){
        // Открываем страницу с drag and drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Находим первый элемент и перемещаем на второй
        $("#column-a").dragAndDropTo($("#column-b"));
        // Проверяем что элемент переместился

    }
}
