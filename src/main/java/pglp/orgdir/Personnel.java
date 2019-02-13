package pglp.orgdir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe <code>Personnel</code> représente un membre d'une organisation.
 *
 * @author hal
 * @version 2019
 */
public class Personnel {
  private String firstname;
  private String lastname;
  private List<String> functions;
  private LocalDate dateOfBirth;

  private Personnel(Builder builder) {
    firstname = builder.firstname;
    lastname = builder.lastname;
    functions = builder.functions;
    dateOfBirth = builder.dateOfBirth;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public List<String> getFunctions() {
    return functions;
  }

  public LocalDate getDoB() {
    return dateOfBirth;
  }

  public static class Builder {
    private String lastname;
    private String firstname;

    public List<String> functions;
    public LocalDate dateOfBirth;

    public Builder(String firstname, String lastname) {
      this.firstname = firstname;
      this.lastname = lastname;
      functions = new ArrayList<>();
    }

    public Personnel build() {
      return new Personnel(this);
    }

    public Builder addFunction(String function) {
      functions.add(function);
      return this;
    }

    public Builder dateOfBirth(int year, int month, int dayOfMonth) {
      dateOfBirth = LocalDate.of(year, month, dayOfMonth);
      return this;
    }
  }
}
