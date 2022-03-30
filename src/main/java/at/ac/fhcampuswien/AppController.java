package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

// with tips from our colleagues
public class AppController {

    private List<Article> articles;


    public AppController() {
    }

    public void setArticles(List<Article> articles) {

    articles = new ArrayList<>();
    }


    private static List<Article> generateMockList() {

    //https://stackoverflow.com/questions/33060592/getters-and-setters-for-arraylists-in-java (30.03.2022 11:16)
    List<Article> articles = new ArrayList<>();
    articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
    articles.add(new Article("Stephen King","I.T."));
    articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
    articles.add(new Article("George Orwell", "1984"));

    return articles;
    }

}
