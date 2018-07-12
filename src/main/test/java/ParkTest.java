import models.Park;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;

    @Before
    public void setUp() {
        park = new Park("Dinoworld", 4055, 1000);
        }

    @Test
    public void hasTill() {
        assertEquals(4055, park.getTill());
    }
}
