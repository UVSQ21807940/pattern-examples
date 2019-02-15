package pglp.orgdir;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonnelGroupTest {
    private Personnel luke;
    private PersonnelGroup starwars;
    private List<OrganizationElement> starwarsDFS;
    private List<OrganizationElement> starwarsBFS;

    @Before
    public void setup() {
        luke = new Personnel.Builder("Luke", "Skywalker").build();
        starwars = new PersonnelGroup("Star Wars");
        PersonnelGroup jedi = new PersonnelGroup("Jedi");
        PersonnelGroup empire = new PersonnelGroup("Empire");
        starwars.add(jedi);
        starwars.add(empire);
        jedi.add(luke);
        Personnel obiwan = new Personnel.Builder("Obiwan", "Kenobi").build();
        jedi.add(obiwan);
        Personnel darkvador = new Personnel.Builder("Dark", "Vador").build();
        empire.add(darkvador);

        starwarsDFS = Arrays.asList(starwars, jedi, luke, obiwan, empire, darkvador);
        starwarsBFS = Arrays.asList(starwars, jedi, empire, luke, obiwan, darkvador);
    }

    @Test
    public void shouldBuildAGroupOfOnePersonnel() {
        PersonnelGroup pg = new PersonnelGroup("Département 1");
        pg.add(luke);

        assertEquals("Département 1", pg.getName());
        assertTrue(pg.contains(luke));
    }

    @Test
    public void shouldBuildAGroupIncludingAGroup() {
        PersonnelGroup pg1 = new PersonnelGroup("Département 1");
        PersonnelGroup pg2 = new PersonnelGroup("Département 2");
        pg1.add(pg2);

        assertTrue(pg1.contains(pg2));
    }

    @Test
    public void shouldGiveTheDescription() {
        PersonnelGroup pg1 = new PersonnelGroup("Département 1");
        PersonnelGroup pg2 = new PersonnelGroup("Département 2");
        pg1.add(pg2);
        pg2.add(luke);

        assertEquals("Département 1 [Département 2 [Luke Skywalker]]", pg1.getDescription());
    }

    @Test
    public void shouldIterateDFS() {
        List<OrganizationElement> elements = new ArrayList<>();
        for (OrganizationElement element : starwars) {
            elements.add(element);
        }

         assertEquals(starwarsDFS, elements);
    }

    @Test
    public void shouldIterateBFS() {
        starwars.setStrategy(OrganizationElement.TraversalStrategy.BFS);
        List<OrganizationElement> elements = new ArrayList<>();
        for (OrganizationElement element : starwars) {
            elements.add(element);
        }

        assertEquals(starwarsBFS, elements);
    }
}
