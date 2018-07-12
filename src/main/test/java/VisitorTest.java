<<<<<<< HEAD

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
||||||| merged common ancestors
=======
import models.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;

    @Before
    public void setUp() {
        Visitor visitor = new Visitor("Bob Jones", 150, 33, 182);
        }

    @Test
    public void hasName() {
        assertEquals("Bob Jones", visitor.getName());
    }
}
>>>>>>> 7568bd2d0ceed0e9cbfed7f15f7757f07a2d9cc5
