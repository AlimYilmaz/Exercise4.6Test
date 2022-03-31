package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

// with tips from our colleagues
public class AppController {

    private List<Article> articles;


    public AppController() {
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;

    }

    public int getArticleCount() {
        if (articles == null){
            return 0;
        }
        else {
            return articles.size();
        }
    }

    public List<Article> getTopHeadlinesAustria() {
        if (articles != null){
            return articles;
        }
        else {
            return new ArrayList<>();
        }
    }

    protected List<Article> filterList(String query, List<Article> articles) {
        List<Article> filteredArticles = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredArticles.add(articles.get(i));
            }
        }
        return filteredArticles;

    }

    public List<Article> getAllNewsBitcoin() {

        return filterList("bitcoin", articles);

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