package pglp.orgdir;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonnelGroupTest {
    private Personnel luke;

    @Before
    public void setup() {
        luke = new Personnel.Builder("Luke", "Skywalker").build();
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
}
