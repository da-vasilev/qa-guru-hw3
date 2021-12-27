import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1024";
    }

    @Test
    public void moveSquareTest() {
        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // - Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        // - Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }
}
