package Kamil.Bookstore.Model.Book;

import Kamil.Bookstore.Model.Author;
import Kamil.Bookstore.Model.Genre;
import Kamil.Bookstore.Model.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate published;
    @ManyToOne
    @JoinColumn(name = "Author_Id", referencedColumnName = "id")
    @Autowired
    private Author author;
    @ManyToOne
    @JoinColumn(name = "Type_Id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "Genre_Id")
    private Genre genre;
    private String coverLink;
    private String pdfLink;
    private Double price;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    public Book() {
    }

    public Book(String name,
                LocalDate published, String coverLink, String pdfLink, Double price, String description) {
        this.name = name;
        this.published = published;
        this.author = author;
        this.type = type;
        this.genre = genre;
        this.coverLink = coverLink;
        this.pdfLink = pdfLink;
        this.price = price;
        this.description = description;
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

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", published=" + published +
                ", author=" + author +
                ", type=" + type +
                ", genre=" + genre +
                ", coverLink='" + coverLink + '\'' +
                ", pdfLink='" + pdfLink + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
