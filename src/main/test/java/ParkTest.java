import models.Park;
import models.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;
    Visitor visitor;

    @Before
    public void setUp() {
        park = new Park("Dinoworld", 4055, 1000);
        visitor = new Visitor("John Johnson", 100, 35, 188);
        }

    @Test
    public void hasTill() {
        assertEquals(4055, park.getTill());
    }

    @Test
    public void canAddVisitorToPark(){
        park.addVisitor(visitor);
        assertEquals(1, park.getVisitorCount());

    }
}
