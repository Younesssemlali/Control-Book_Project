import com.example.book.dao.entities.Book;
import com.example.book.dao.repositories.IBookRepository;
import com.example.book.service.BookManager;
import com.example.book.service.dtos.BookDTO;
import com.example.book.service.mappers.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookManagerAction implements BookManager {

    private final IBookRepository iBookRepository;
    private final BookMapper mapper;

    public BookManagerAction(IBookRepository iBookRepository, BookMapper mapper) {
        this.iBookRepository = iBookRepository;
        this.mapper = mapper;
    }


    @Override
    public List<BookDTO> getBookByTitle(String titre) {
        return iBookRepository.findBooksByTitreContaining(titre).stream().map(mapper::fromBookToBookDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBookByPublisherAndPrice(String publisher, double price) {
        return iBookRepository.findBooksByPublisherContainingAndPrice(publisher,price).stream().map(mapper::fromBookToBookDto).collect(Collectors.toList());
    }

    @Override
    public BookDTO saveBook(BookDTO bookDto) {
        Book book = mapper.fromBookDTOtoBook(bookDto);
        boolean exist = iBookRepository.existsBookByPublisherAndTitre(book.getPublisher(),book.getTitre());
        if (exist){
            throw new RuntimeException("book exist with this publisher and title");
        }
        Book book1 = iBookRepository.save(book);
        return mapper.fromBookToBookDto(book1);
    }

    @Override
    public BookDTO deleteBook(Long id) {
        Book book = iBookRepository.findById(id).orElseThrow(()->new RuntimeException("book doesn't exist"));
        iBookRepository.deleteById(id);
        return mapper.fromBookToBookDto(book);
    }
}
