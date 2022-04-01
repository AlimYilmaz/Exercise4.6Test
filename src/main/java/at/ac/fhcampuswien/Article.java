package at.ac.fhcampuswien;

public class Article {

    private String author;
    private String title;

    //constructors for two member variables
    public Article(String author, String title){

        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + " "; // https://stackoverflow.com/questions/19008970/java-what-does-n-mean
    }
}