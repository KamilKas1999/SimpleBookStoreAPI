package Kamil.Bookstore.Model;

import Kamil.Bookstore.Model.Book.Book;
import Kamil.Bookstore.Model.Book.BooksForAuthor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @OneToMany(mappedBy = "author", cascade = CascadeType.DETACH)
    private List<Book> books;

    public Author() {

    }


    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<BooksForAuthor> getBooks() {
        return books.stream().map(book -> {
            return new BooksForAuthor(book.getId(),book.getName(), book.getType(), book.getGenre(), book.getCoverLink(), book.getPrice());
        }).collect(Collectors.toList());
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
