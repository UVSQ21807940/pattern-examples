package pglp.orgdir;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonnelTest {
  @Test
  public void shouldCreateAPersonnelWithAGivenName() {
    Personnel p = new Personnel.Builder("Luke", "Skywalker").build();

    assertPersonnel(p, "Luke", "Skywalker", Collections.emptyList(), 2000, 1, 1);
  }

  @Test
  public void shouldCreateAPersonnelWithAGivenNameAndAFunction() {
    Personnel p = new Personnel.Builder("Luke", "Skywalker")
      .addFunction("Chargé de mission")
      .addFunction("Directeur")
      .build();

    assertPersonnel(p, "Luke", "Skywalker", Arrays.asList("Chargé de mission", "Directeur"), 2000, 1, 1);
  }

  @Test
  public void shouldCreateAPersonnelWithADoB() {
    Personnel p = new Personnel.Builder("Luke", "Skywalker")
      .dateOfBirth(2007, 10, 4)
      .build();

    assertPersonnel(p, "Luke", "Skywalker", Collections.emptyList(), 2007, 10, 4);
  }

  @Test
  public void shouldGenerateAValidString() {
    Personnel p = new Personnel.Builder("Luke", "Skywalker")
            .dateOfBirth(2007, 10, 4)
            .build();

    assertEquals("Personnel{lastname='Skywalker', firstname='Luke'}", p.toString());
  }

  private static void assertPersonnel(Personnel p, String firstname, String lastname, List<String> functions, int year, int month, int dayOfMonth) {
    assertEquals(firstname, p.getFirstname());
    assertEquals(lastname, p.getLastname());
    assertEquals(functions, p.getFunctions());
    assertEquals(LocalDate.of(year, month, dayOfMonth), p.getDoB());
  }
}
