package de.codecentric.psd.worblehat.web.formdata;

import de.codecentric.psd.worblehat.web.validation.ISBN;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/** Form data object from the borrow view. */
public class ShowBorrowedBooksFormData {

  @NotEmpty(message = "{empty.borrowCmd.email}")
  @Email(message = "{notvalid.borrowCmd.email}")
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
