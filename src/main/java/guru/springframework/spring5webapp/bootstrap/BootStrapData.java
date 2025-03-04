package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher("Publising","St peter");
        publisherRepository.save(publisher);
        System.out.println("Publisher count" + publisherRepository.count());
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("yqyqyqy","283467382");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author yueqi = new Author("xixi", "haha");
        Book troll = new Book("new troll", "83728");
        yueqi.getBooks().add(troll);
        troll.getAuthors().add(yueqi);

        authorRepository.save(yueqi);
        bookRepository.save((troll));

        System.out.println("NUmber of Books:" + bookRepository.count());
    }
}
