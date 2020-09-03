package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.domain.Borrowing;
import de.codecentric.psd.worblehat.web.formdata.BookBorrowFormData;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Controller for BorrowingBook */
@RequestMapping("/showBorrowedBooks")
@Controller
public class ShowBorrowedBooksController {

  private BookService bookService;

  @Autowired
  public ShowBorrowedBooksController(BookService bookService) {
    this.bookService = bookService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public void setupForm(final ModelMap model) {
    model.put("showBorrowedBooksFormData", new ShowBorrowedBooksFormData());
  }

  @Transactional
  @RequestMapping(method = RequestMethod.POST)
  public String processSubmit(
      @ModelAttribute("showBorrowedBooks") @Valid ShowBorrowedBooksFormData showBorrowedBooksFormData,
      BindingResult result) {
    if (result.hasErrors()) {
      return "showBorrowedBooks";
    }
    Set<Book> books = bookService.findBooksByEmail(showBorrowedBooksFormData.getEmail());
    if (books.isEmpty()) {
      result.rejectValue("email", "noBorrowsExists");
      return "showBorrowedBooks";
    }
    List<Book> books = bookService.findAllBooks();

    //Optional<Borrowing> borrowing =
      //  bookService.borrowBook(borrowFormData.getIsbn(), borrowFormData.getEmail());

    return borrowing
        .map(b -> "home")
        .orElseGet(
            () -> {
              result.rejectValue("isbn", "noBorrowableBooks");
              return "borrow";
            });
  }

  @ExceptionHandler(Exception.class)
  public String handleErrors(Exception ex, HttpServletRequest request) {
    return "home";
  }
}