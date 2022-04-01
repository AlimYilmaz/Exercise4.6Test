package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

// with tips from our colleague
public class AppController {

    private List<Article> articles;


    public AppController() {
    }

    public void setArticles(List<Article> articles) { //Setter für die Artikel Liste
        this.articles = articles;

    }

    public int getArticleCount() {
        if (articles == null){ // wenn articles null ist, soll null zurückgegeben werden
            return 0;
        }
        else {
            return articles.size(); // wenn nicht, dann die Anzahl
        }
    }

    public List<Article> getTopHeadlinesAustria() {
        if (articles != null){ //Liste null --> leere Liste
            return articles;
        }
        else {
            return new ArrayList<>(); // Liste der Artikel zurückgeben
        }
    }

    protected List<Article> filterList(String query, List<Article> articles) {
        List<Article> filteredArticles = new ArrayList<>(); //filteredList wird erstellt
        for (int i = 0; i < articles.size(); i++) { //geht jede Liste durch
            if (articles.get(i).getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredArticles.add(articles.get(i)); // sucht das Wort
            }
        }
        return filteredArticles; // gibt die Liste zurück, in dem Query vorkommt

    }

    public List<Article> getAllNewsBitcoin() {

        return filterList("bitcoin", articles); // Artikel mit Bitcoin zurück

    }

    private static List<Article> generateMockList() { // eine Liste mit Dummy-Werten

        //https://stackoverflow.com/questions/33060592/getters-and-setters-for-arraylists-in-java (30.03.2022 11:16)
        List<Article> articles = new ArrayList<>(); //neue Liste

        articles.add(new Article("Stefan Zweig", "Die Welt von Gestern"));
        articles.add(new Article("Stephen King","I.T."));
        articles.add(new Article("Harper Lee", "To kill a Mockingbird"));
        articles.add(new Article("George Orwell", "1984"));


        return articles;
    }

}