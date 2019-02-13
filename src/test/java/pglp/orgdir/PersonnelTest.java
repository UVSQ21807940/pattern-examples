package pglp.orgdir;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PersonnelTest {
  @Test
  public void shouldCreateAPersonnelWithAGivenName() {
    Personnel p = new Personnel.Builder("Luke", "Skywalker").build();

    assertEquals("Luke", p.getFirstname());
    assertEquals("Skywalker", p.getLastname());
  }

  @Test
  public void shouldCreateAPersonnelWithAGivenNameAndAFunction() {
    Personnel p = new Personnel.Builder("Luke", "Skywalker")
      .addFunction("Chargé de mission")
      .addFunction("Directeur")
      .build();

    assertEquals("Luke", p.getFirstname());
    assertEquals("Skywalker", p.getLastname());
    assertEquals(Arrays.asList("Chargé de mission", "Directeur"), p.getFunctions());
  }

  @Test
  public void shouldCreateAPersonnelWithADoB() {
    Personnel p = new Personnel.Builder("Luke", "Skywalker")
      .dateOfBirth(2007, 10, 4)
      .build();

    assertEquals("Luke", p.getFirstname());
    assertEquals("Skywalker", p.getLastname());
    assertEquals(LocalDate.of(2007, 10, 4), p.getDoB());
  }

}
