package at.ac.fhcampuswien;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AppControllerTest {


    private static AppController ctrl;

    @BeforeAll
    public static void beforeAll() { ctrl = new AppController(); }

    @Test
    @DisplayName("check if setArticle is working by checking if the list is empty")
    public void testIfSetArticleIsWorkingByCheckingList() throws NoSuchFieldException {
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article("George Orwell", "1984"));
        ctrl.setArticles(articleList);
        Assertions.assertTrue(ctrl.getArticleCount() != 0);
    }

    @Test
    @DisplayName("test if articleCount returns zero when null")
    public void testIfArticleCountIsZeroWhenArticlesNull()
    {Assertions.assertTrue(ctrl.getArticleCount() = 0);}
}
