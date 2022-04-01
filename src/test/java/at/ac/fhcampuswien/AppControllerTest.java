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
    public void testIfSetArticleIsWorkingByCheckingList() throws NoSuchFieldException { //The code is testing if the article is set
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
    public void testIfArticleCountIs4(){
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articleList.add(new Article("Stephen King","I.T."));
        articleList.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articleList.add(new Article("George Orwell", "1984"));
    Assertions.assertEquals(4,ctrl.getArticleCount(),4);
    }

    @Test
    @DisplayName("test if getTopHeadLinesAustria is empty when it has elements in there")
    public void  testIfGetTopHeadLinesAustriaIsEmptyWhenHasElements(){ //if the test returns an empty list when it has elements in there
        Assertions.assertFalse(ctrl.getTopHeadlinesAustria().isEmpty()); //false --> doesn't return empty list
    }

    @Test
    @DisplayName("test if GetTopHeadlinesAustria returns empty when the list is null")
    public void testIfGetTopHeadlinesAustriaIsEmptyWhenListNull(){
        ctrl.setArticles(null);
        Assertions.assertEquals(0, ctrl.getTopHeadlinesAustria().size());
    }

    // https://stackoverflow.com/questions/26102865/assertequals-what-is-actual-and-what-is-expected (31.03.)
    @Test
    @DisplayName("if articleCount is really zero when no articles")
    public void testIfArticleCountZeroWhenArticlesAreNull() {
        //AppController appController = new AppController();
        ctrl.setArticles(null);

        Assertions.assertEquals(0, ctrl.getArticleCount());
    }

    @Test
    @DisplayName("test if the searched element is in the list")
    public void testIfTheSearchedElementIsInTheList(){
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articles.add(new Article("Stephen King","I.T."));
        articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articles.add(new Article("George Orwell", "1984"));

        List<Article> filteredList = ctrl.filterList("gestern", articles); //searching for "Gestern"
        Assertions.assertTrue(filteredList.size() == 1);
    }

    @Test
    @DisplayName("test checks if the word bitcoin is contained in the list")
    public void TestIfFilterListContainsBitcoin(){
        //to have something to filter
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articles.add(new Article("Stephen King","I.T."));
        articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articles.add(new Article("George Orwell", "1984"));
        articles.add(new Article("Saifedean Ammous", "The Bitcoin Standard: The Decentralized Alternative to Central Banking"));

        ctrl.setArticles(articles);

        List<Article> NewsAboutBitcoinList = ctrl.getAllNewsBitcoin();

        List<Article> newsAboutBitcoinList = ctrl.getAllNewsBitcoin();
        boolean containsBitcoin = false; // doesn't contain bitcoin --> false
        for (Article article: newsAboutBitcoinList) {
            if (article.getTitle().toLowerCase().contains("bitcoin")) {
                containsBitcoin = true; // does contain bitcoin --> true
            }
        }
        Assertions.assertTrue(containsBitcoin);
        }

}
