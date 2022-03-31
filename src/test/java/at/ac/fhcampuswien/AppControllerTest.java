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
        articleList.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articleList.add(new Article("Stephen King","I.T."));
        articleList.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articleList.add(new Article("George Orwell", "1984"));
        ctrl.setArticles(articleList);
        Assertions.assertTrue(ctrl.getArticleCount() != 0);
    }

    @Test
    @DisplayName("test if articleCount return the number of the articles we have")
    public void testIfArticleCountIs4()
    {Assertions.assertEquals(ctrl.getArticleCount(),4);}

    @Test
    @DisplayName("test if getTopHeadLinesAustria is empty when it has elements in there")
    public void  testIfGetTopHeadLinesAustriaIsEmptyWhenHasElements(){
        Assertions.assertFalse(ctrl.getTopHeadlinesAustria().isEmpty());
    }

    @Test
    @DisplayName("test if the searched element is in the list")
    public void testIfTheSearchedElementIsInTheList(){
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articles.add(new Article("Stephen King","I.T."));
        articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articles.add(new Article("George Orwell", "1984"));

        List<Article> filteredList = ctrl.filterList("gestern", articles);
        Assertions.assertTrue(filteredList.size() != 0);
    }

    @Test
    @DisplayName("test checks if the word bitcoin is contained in the list")
    public void TestIfFilterListContainsBitcoin(){
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articles.add(new Article("Stephen King","I.T."));
        articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articles.add(new Article("George Orwell", "1984"));
        articles.add(new Article("Saifedean Ammous", "The Bitcoin Standard: The Decentralized Alternative to Central Banking"));

        List<Article> NewsAboutBitcoinList = ctrl.getAllNewsBitcoin();

        for (int i = 0; i < NewsAboutBitcoinList.size(); i++) {
            System.out.println(NewsAboutBitcoinList.get(i));
        }

        NewsAboutBitcoinList.forEach(article -> {
            System.out.println(article);
        });
    }

}
