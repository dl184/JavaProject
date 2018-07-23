
import models.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;

    @Before
    public void setup(){
        visitor = new Visitor("Percy J. Moore",90,30,182);
    }

    @Test
    public void hasName() {
        assertEquals("Percy J. Moore",visitor.getName());
    }

    @Test
    public void hasMoney(){
        assertEquals(90,visitor.getWallet());
    }

    @Test
    public void hasAge() {
        assertEquals(30,visitor.getAge());
    }

    @Test
    public void hasHeight(){
        assertEquals(182, visitor.getHeight());
    }

}
