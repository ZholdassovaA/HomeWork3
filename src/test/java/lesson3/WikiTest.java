package lesson3;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiTest {

    @Test
    public void findCodeForJUnit5() {
        // Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // Перейти в раздел Wiki
        $("#wiki-tab").click();

        // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").click();
        $("#wiki-pages-filter").setValue("so");

        // Открыть страницу SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        // Проверить, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}