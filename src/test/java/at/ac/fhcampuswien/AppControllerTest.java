package at.ac.fhcampuswien;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class AppControllerTest {


    private static AppController ctrl;
    private List<Article> mocklist;
    private Article zweigArticle;
    private Article kingArticle;
    private Article leeArticle;
    private Article orwellArticle;
    private Article bitcoinArticle;

    @BeforeEach
    void setup() {
        ctrl = new AppController();
        mocklist = new ArrayList<>();
        zweigArticle = (new Article("Stefan Zweig", "Die Welt von Gestern"));
        mocklist.add(zweigArticle);
        kingArticle = (new Article("Stephen King", "I.T."));
        mocklist.add(kingArticle);
        leeArticle = (new Article("Harper Lee", "To kill a Mockingbird"));
        mocklist.add(leeArticle);
        orwellArticle = (new Article("George Orwell", "1984"));
        mocklist.add(orwellArticle);
        bitcoinArticle = (new Article("Saifedean Ammous", "The Bitcoin Standard: The Decentralized Alternative to Central Banking"));
        mocklist.add(bitcoinArticle);
        ctrl.setArticles(mocklist);
    }


    @Test
    @DisplayName("check if setArticle is working by checking if the list is empty")
    public void testIfSetArticleIsWorkingByCheckingList()  { //The code is testing if the article is set
        Assertions.assertEquals(mocklist.size(), ctrl.getArticleCount());
    }

    @Test
    @DisplayName("test if articleCount return the number of the articles we have")
    public void testIfArticleCountIs5(){
        Assertions.assertEquals(5, ctrl.getArticleCount());
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

        Assertions.assertEquals(5, ctrl.getArticleCount());
    }

    @Test
    @DisplayName("test if the searched element is in the list")
    public void testIfTheSearchedElementIsInTheList(){
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articles.add(new Article("Stephen King","I.T."));
        articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articles.add(new Article("George Orwell", "1984"));
        articles.add(new Article("Saifedean Ammous", "The Bitcoin Standard: The Decentralized Alternative to Central Banking"));

        List<Article> filteredList = ctrl.filterList("gestern", articles); //searching for "Gestern"
        Assertions.assertTrue(filteredList.size() != 0);
    }


    @Test
    @DisplayName("test if the searched element is in the list")
    public void testIfTheSearchedElementIsInTheList2(){
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articles.add(new Article("Stephen King","I.T."));
        articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articles.add(new Article("George Orwell", "1984"));
        articles.add(new Article("Saifedean Ammous", "The Bitcoin Standard: The Decentralized Alternative to Central Banking"));

        List<Article> filteredList = ctrl.filterList("1984", articles); //searching for "1984"
        Assertions.assertTrue(filteredList.size() != 0);
    }


    @Test
    @DisplayName("test if the searched element is in the list")
    public void testIfTheSearchedElementIsInTheList3(){
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articles.add(new Article("Stephen King","I.T."));
        articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articles.add(new Article("George Orwell", "1984"));
        articles.add(new Article("Saifedean Ammous", "The Bitcoin Standard: The Decentralized Alternative to Central Banking"));

        List<Article> filteredList = ctrl.filterList("kill", articles); //searching for "kill"
        Assertions.assertTrue(filteredList.size() != 0);
    }

    @Test
    @DisplayName("test to see if filter list doesn't contain searched element")
    public void TestIfFilterListDoesNotContainSearchedElement(){
        String query = "EntryIsNonExisting";
        List<Article> filteredList = ctrl.filterList(query, mocklist); // The List stays empty if the title isn't entailed in the list
        Assertions.assertTrue(filteredList.isEmpty());
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
                break;
            }
        }
        Assertions.assertTrue(containsBitcoin);
        }

}