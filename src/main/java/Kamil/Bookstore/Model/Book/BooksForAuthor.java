package Kamil.Bookstore.Model.Book;

import Kamil.Bookstore.Model.Genre;
import Kamil.Bookstore.Model.Type;

public class BooksForAuthor {
    private Long id;
    private String name;
    private Type type;
    private Genre genre;
    private String coverLink;
    private Double price;

    public BooksForAuthor() {
    }

    public BooksForAuthor(Long id, String name, Type type, Genre genre, String coverLink, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.genre = genre;
        this.coverLink = coverLink;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
