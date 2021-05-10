package Kamil.Bookstore.Services;

import Kamil.Bookstore.Repository.AuthorRepository;
import Kamil.Bookstore.Repository.BookRepository;
import Kamil.Bookstore.Repository.GenresRepository;
import Kamil.Bookstore.Repository.TypesRepository;
import Kamil.Bookstore.Model.Book.Book;
import Kamil.Bookstore.Model.Book.BookWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenresRepository genreRepository;
    private final TypesRepository typesRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, GenresRepository genreRepository, TypesRepository typesRepository) {
        this.bookRepository = bookRepository;

        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.typesRepository = typesRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book findBook(Long id) {
        return bookRepository.findBookById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Book> searchBook(String text){
        System.out.println(text);
        List<Book> books = bookRepository.findAll();
        List<Book> searched = books.stream().filter(book ->
        {
            return book.getName().contains(text);
        }
        ).collect(Collectors.toList());
        return searched;
    }

    public Book addBook(BookWrite book) {
        Book newBook = new Book(book.getName(),
                book.getPublished(),
                book.getCoverLink(),
                book.getPdfLink(),
                book.getPrice(),
                book.getDescription());
        newBook.setAuthor(authorRepository.findById(book.getAuthorId()).get());
        newBook.setGenre(genreRepository.findById(book.getGenreId()).get());
        newBook.setType(typesRepository.findById(book.getTypeId()).get());
        return bookRepository.save(newBook);
    }



    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}
