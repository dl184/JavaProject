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
        paddock1 = new Paddock("Zone 1", 6, DinosaurFood.COW);
        paddock2 = new Paddock("Zone 2", 4, DinosaurFood.PLANTS);
        }

    @Test
    public void hasName() {
        assertEquals("Zone 1", paddock1.getName());
    }
}
