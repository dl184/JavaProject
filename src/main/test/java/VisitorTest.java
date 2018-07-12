import models.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;

    @Before
    public void setUp() {
        visitor = new Visitor("Bob Jones", 150, 33, 182);
        }

    @Test
    public void hasName() {
        assertEquals("Bob Jones", visitor.getName());
    }
}
