package Kamil.Bookstore.Model.Book;

import java.time.LocalDate;

public class BookWrite {
    private Long id;
    private String name;
    private LocalDate published;
    private Long authorId;
    private Long genreId;
    private Long typeId;
    private String coverLink;
    private String pdfLink;

    private Double price;
    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPublished() {
        return published;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
