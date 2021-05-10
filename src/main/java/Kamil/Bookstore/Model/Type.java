package Kamil.Bookstore.Model;

import Kamil.Bookstore.Model.Book.Book;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "TypeId")
//    private List<Book> books;

    public Type() {
    }

    public Type(String name, List<Book> books) {
        this.name = name;
       // this.books = books;
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

//    public List<Book> getBooks() {
//       // return books;
//    }

    public void setBooks(List<Book> books) {
      //  this.books = books;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + "books" +
                '}';
    }
}
