import models.DinosaurFood;
import models.Paddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {

    Paddock paddock1;
    Paddock paddock2;

    @Before
    public void setUp() {
        DinosaurFood plants = new DinosaurFood("Plants");
        DinosaurFood cow = new DinosaurFood("Cow");
        DinosaurFood goat = new DinosaurFood("Goat");
        paddock1 = new Paddock("Zone 1", "Carnivores", 6, cow);
        paddock2 = new Paddock("Zone 2", "Herbivores", 4, plants);
        }

    @Test
    public void hasName() {
        assertEquals("Zone 1", paddock1.getName());
    }
}
